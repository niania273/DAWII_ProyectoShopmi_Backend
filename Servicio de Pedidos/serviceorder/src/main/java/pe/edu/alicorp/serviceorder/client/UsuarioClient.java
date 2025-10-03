package pe.edu.alicorp.serviceorder.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import pe.edu.alicorp.commondto.dto.UsuarioDTO;

@FeignClient( name = "autentication-service", url = "http://localhost:8081")
public interface UsuarioClient {

    @GetMapping("/usuarios/{id}")
    UsuarioDTO obtenerUsuario(Long codUsuario);
}
