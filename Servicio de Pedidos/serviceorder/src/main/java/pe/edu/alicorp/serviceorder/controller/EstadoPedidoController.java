package pe.edu.alicorp.serviceorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.alicorp.commondto.dto.SelectResponseDTO;
import pe.edu.alicorp.serviceorder.service.EstadoPedidoService;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoPedidoController {

    @Autowired
    private EstadoPedidoService service;

    @GetMapping("/get")
    public ResponseEntity<List<SelectResponseDTO>> getAllActive(){
        List<SelectResponseDTO> listaEstados = service.findAll()
                .stream().map(estadoPedido -> {
                               SelectResponseDTO dto = new SelectResponseDTO();
                               dto.setValue(estadoPedido.getCodEstado());
                               dto.setName(estadoPedido.getNomEstado());
                               return dto;
        }).toList();

        return ResponseEntity.ok(listaEstados);
    }

    /*@GetMapping("/get/{id}")
    public ResponseEntity<SelectResponseDTO> getById(Long id){
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }*/
}
