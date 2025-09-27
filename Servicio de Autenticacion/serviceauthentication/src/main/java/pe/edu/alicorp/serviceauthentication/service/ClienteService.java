package pe.edu.alicorp.serviceauthentication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.alicorp.commondto.dto.RegisterDTO;
import pe.edu.alicorp.serviceauthentication.entity.Cliente;
import pe.edu.alicorp.serviceauthentication.repository.ClienteRepository;

import java.util.*;

@Service @RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository repo;

    public Map<String,String> validate(RegisterDTO dto){
        Map<String,String> e = new HashMap<>();
        if (repo.existsByNrodoc(dto.getNroDoc())) e.put("nroDoc","Documento ya registrado");
        if (dto.getCorCliente()!=null && !dto.getCorCliente().isBlank() && repo.existsByCorcliente(dto.getCorCliente()))
            e.put("corCliente","Correo ya registrado");
        return e;
    }

    @Transactional
    public Long create(RegisterDTO dto){
        Cliente c = new Cliente();
        c.setRazsocial(dto.getRazonSocial());
        c.setNrodoc(dto.getNroDoc());
        c.setCorcliente(dto.getCorCliente());
        c.setEstcliente(1);
        repo.save(c);
        return c.getCodcliente().longValue();
    }

    @Transactional
    public void delete(Long id){ repo.deleteById(id.intValue()); }
}
