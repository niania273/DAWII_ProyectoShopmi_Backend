package pe.edu.alicorp.servicecatalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.alicorp.servicecatalog.entity.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
    boolean existsByNombre(String nombre);
}
