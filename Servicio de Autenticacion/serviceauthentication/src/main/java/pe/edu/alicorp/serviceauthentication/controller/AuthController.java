package pe.edu.alicorp.serviceauthentication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pe.edu.alicorp.commondto.dto.LoginDTO;
import pe.edu.alicorp.commondto.dto.RegisterDTO;
import pe.edu.alicorp.serviceauthentication.entity.Role;
import pe.edu.alicorp.serviceauthentication.entity.User;
import pe.edu.alicorp.serviceauthentication.repository.RoleRepository;
import pe.edu.alicorp.serviceauthentication.repository.UserRepository;
import pe.edu.alicorp.serviceauthentication.service.JwtUtil;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDTO dto) {
        if (userRepository.existsByEmail(dto.getCorreo())) {
            return ResponseEntity.badRequest().body("El correo ya está registrado");
        }

        User user = new User();
        user.setFirstName(dto.getNombre());
        user.setLastName(dto.getApellido());
        user.setEmail(dto.getCorreo());
        user.setPhone(dto.getTelefono());
        user.setBirthDate(dto.getFechaNacimiento());
        user.setSex(String.valueOf(dto.getSexo()));
        user.setPasswordHash(passwordEncoder.encode(dto.getContrasenia()));

        // Asignamos rol por defecto (Cliente = 1)
        Optional<Role> role = roleRepository.findById(1);
        role.ifPresent(user::setRole);
        user.setCodCliente(1);

        userRepository.save(user);

        return ResponseEntity.ok("Usuario registrado correctamente");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO dto) {
        Optional<User> userOpt = userRepository.findByEmail(dto.getCorreo());

        if (userOpt.isEmpty()) {
            return ResponseEntity.status(401).body("Usuario no encontrado");
        }

        User user = userOpt.get();
        if (!passwordEncoder.matches(dto.getContrasenia(), user.getPasswordHash())) {
            return ResponseEntity.status(401).body("Contraseña incorrecta");
        }

        String token = jwtUtil.generateToken(user);

        return ResponseEntity.ok(Map.of(
                "token", token,
                "usuario", user
        ));
    }
}
