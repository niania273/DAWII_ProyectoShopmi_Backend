package pe.edu.alicorp.serviceauthentication.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.alicorp.serviceauthentication.dto.RegisterDTO;
import pe.edu.alicorp.serviceauthentication.service.ClienteService;

import java.util.Map;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteService service;

    @PostMapping("/validate")
    public ResponseEntity<Map<String,String>> validate(@Valid @RequestBody RegisterDTO dto){
        var errors = service.validate(dto);
        return errors.isEmpty() ? ResponseEntity.ok(Map.of()) : ResponseEntity.badRequest().body(errors);
    }

    @PostMapping
    public ResponseEntity<Long> create(@Valid @RequestBody RegisterDTO dto){
        return ResponseEntity.ok(service.create(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
