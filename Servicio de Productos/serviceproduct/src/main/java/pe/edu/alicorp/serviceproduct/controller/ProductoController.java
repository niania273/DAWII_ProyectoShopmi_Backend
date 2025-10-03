package pe.edu.alicorp.serviceproduct.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.alicorp.serviceproduct.model.Producto;
import pe.edu.alicorp.serviceproduct.service.ProductoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    //Listar todos los productos
    @GetMapping("/listarProductos")
    public ResponseEntity<List<Producto>> obtenerProductos(){
        return ResponseEntity.of(Optional.ofNullable(productoService.obtenerProductos()));
    }

    //Guardar producto nuevo
    @PostMapping("/agregarProducto")
    public ResponseEntity<Producto> guardarProducto(@RequestBody Producto producto){
        return ResponseEntity.ok(productoService.guardarProducto(producto));
    }

    //Obtener un producto por su Id
    @GetMapping("/obtenerProducto/{id}")
    public ResponseEntity<Producto> buscarProductoPorId(@PathVariable Long id) {
        Producto producto = productoService.buscarProductoPorId(id);
        return (producto != null) ? ResponseEntity.ok(producto) : ResponseEntity.notFound().build();
    }

    //Actualizar un producto por su Id
    @PutMapping("/actualizarProducto/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto producto){
        Producto producto1 = productoService.actualizarProducto(id, producto);
        return (producto1 != null) ? ResponseEntity.ok(producto1) : ResponseEntity.notFound().build();
    }

    //Desactivar estado(Habilitado - Deshabilitado) de un producto por su Id
    @DeleteMapping("/deshabilitarProducto/{id}")
    public ResponseEntity<Void> deshabilitarProducto(@PathVariable Long id){
        boolean resultado = productoService.deshabilitarProducto(id);
        return resultado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
