package pe.edu.alicorp.serviceorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.alicorp.serviceorder.model.EstadoPedido;
import pe.edu.alicorp.serviceorder.service.EstadoPedidoService;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoPedidoController {

    @Autowired
    private EstadoPedidoService service;

    @GetMapping("/get")
    public List<EstadoPedido> getAllActive(){
        return service.findAllActive();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<EstadoPedido> getById(Long id){
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
}
