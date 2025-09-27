package pe.edu.alicorp.serviceauthentication.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.alicorp.commondto.dto.RegisterDTO;

import java.util.Map;

@FeignClient(name="cliente-service", url="${cliente.service.url}")
public interface ClienteFeignClient {

    @PostMapping("/api/clientes/validate")
    ResponseEntity<Map<String,String>> validate(@RequestBody RegisterDTO dto);

    @PostMapping("/api/clientes")
    ResponseEntity<Long> create(@RequestBody RegisterDTO dto);

    @DeleteMapping("/api/clientes/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
