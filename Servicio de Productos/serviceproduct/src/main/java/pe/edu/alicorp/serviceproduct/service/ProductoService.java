package pe.edu.alicorp.serviceproduct.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.alicorp.serviceproduct.model.Producto;
import pe.edu.alicorp.serviceproduct.repository.ProductoRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;

    public List<Producto> obtenerProductos(){
        return productoRepository.findAll();
    }

    public Producto guardarProducto(Producto producto){
        return productoRepository.save(producto);
    }

    public Producto buscarProductoPorId(Long id){
        return productoRepository.findById(id).orElse(null);
    }

    public Producto actualizarProducto(Long id, Producto producto){
        Optional<Producto> productoexist = productoRepository.findById(id);
        return productoexist.map(producto1 -> {
            producto1.actualizarProducto(producto);
            producto1.setFechaactualiza(LocalDateTime.now());
            return productoRepository.save(producto1);
        }).orElse(null);
    }

    public boolean deshabilitarProducto(Long id){
        return productoRepository.findById(id).map(producto -> {
            producto.setEstproducto(false);
            producto.setFechaactualiza(LocalDateTime.now());
            productoRepository.save(producto);
            return true;
        }).orElse(false);
    }
}
