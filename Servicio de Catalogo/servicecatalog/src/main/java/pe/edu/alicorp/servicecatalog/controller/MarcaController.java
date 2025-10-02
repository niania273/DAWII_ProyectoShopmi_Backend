package pe.edu.alicorp.servicecatalog.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.alicorp.servicecatalog.entity.Marca;
import pe.edu.alicorp.servicecatalog.service.MarcaService;

import java.util.List;

@RestController
@RequestMapping("/marcas")
public class MarcaController {

    private final MarcaService service;

    public MarcaController(MarcaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Marca> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Marca buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Marca crear(@RequestBody Marca marca) {
        return service.guardar(marca);
    }

    @PutMapping("/{id}")
    public Marca actualizar(@PathVariable Long id, @RequestBody Marca marca) {
        Marca existente = service.buscarPorId(id);
        existente.setNombre(marca.getNombre());
        existente.setImg(marca.getImg());
        existente.setEstado(marca.getEstado());
        return service.guardar(existente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

