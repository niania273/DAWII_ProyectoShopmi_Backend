package pe.edu.alicorp.serviceauthentication.service;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.alicorp.serviceauthentication.Client.ClienteFeignClient;
import pe.edu.alicorp.commondto.dto.LoginDTO;
import pe.edu.alicorp.commondto.dto.RegisterDTO;
import pe.edu.alicorp.serviceauthentication.entity.Role;
import pe.edu.alicorp.serviceauthentication.entity.User;
import pe.edu.alicorp.serviceauthentication.repository.RoleRepository;
import pe.edu.alicorp.serviceauthentication.repository.UserRepository;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;

@Service @RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
    private final PasswordEncoder encoder;
    private final ClienteFeignClient clienteFeign;

    public String register(RegisterDTO dto){
        // 1) Validación simple de usuario (email único)
        if (userRepo.existsByEmail(dto.getCorUsuario())) return "El correo ya está registrado";

        // 2) Validación de cliente remota
        ResponseEntity<Map<String,String>> val = clienteFeign.validate(dto);
        if (val.getStatusCode().is4xxClientError() && val.getBody()!=null && !val.getBody().isEmpty())
            return "Error CLIENTE: " + val.getBody();

        // 3) Crear cliente remoto
        Long codCliente;
        try {
            codCliente = clienteFeign.create(dto).getBody();
            if (codCliente == null) return "No se pudo crear el cliente";
        } catch (Exception e){
            return "Fallo creando cliente: " + e.getMessage();
        }

        // 4) Guardar usuario local; si falla → compensación (borrar cliente)
        try {
            Role defaultRole = roleRepo.findById(1).orElseGet(() -> {
                Role r = new Role(); r.setId(1); r.setName("USER"); r.setStatus(1); return roleRepo.save(r);
            });

            User u = new User();
            u.setLastName(dto.getApeUsuario());
            u.setFirstName(dto.getNomUsuario());
            u.setBirthDate(Date.valueOf(dto.getFecNac()));
            u.setSex(dto.getSexUsuario());
            u.setPhone(dto.getTelUsuario());
            u.setEmail(dto.getCorUsuario());
            u.setPasswordHash(encoder.encode(dto.getPassword()));
            u.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()).toLocalDateTime());
            u.setStatus(1);
            u.setCodCliente(codCliente.intValue());
            u.setRole(defaultRole);

            userRepo.save(u);
            return "¡Éxito! Usuario registrado";
        } catch (Exception e){
            try { clienteFeign.delete(codCliente); } catch (Exception ignore) {}
            return "Se creó el cliente pero falló el usuario. Rollback aplicado.";
        }
    }

    public String login(LoginDTO dto, AuthenticationManager authManager){
        try {
            Authentication auth = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(auth);
            return "¡Éxito! Sesión iniciada";
        } catch (AuthenticationException e){
            return "Credenciales inválidas";
        }
    }
}
