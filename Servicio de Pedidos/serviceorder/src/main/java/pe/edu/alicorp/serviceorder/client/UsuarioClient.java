package pe.edu.alicorp.serviceorder.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient( name = "autentication-service", url = "http://localhost:8082")
public interface UsuarioClient {

    //@GetMapping("/productos/get")
    //public UsuarioDTO getById(Long codUsuario);
}
