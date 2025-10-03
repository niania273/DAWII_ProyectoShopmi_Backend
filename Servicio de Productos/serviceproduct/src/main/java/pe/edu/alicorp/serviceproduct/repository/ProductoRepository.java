package pe.edu.alicorp.serviceproduct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.alicorp.serviceproduct.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
