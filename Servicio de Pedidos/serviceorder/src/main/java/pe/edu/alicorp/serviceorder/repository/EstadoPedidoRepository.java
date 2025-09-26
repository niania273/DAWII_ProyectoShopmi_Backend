package pe.edu.alicorp.serviceorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.alicorp.serviceorder.model.EstadoPedido;

import java.util.List;

@Repository
public interface EstadoPedidoRepository extends JpaRepository<EstadoPedido, Long> {
    List<EstadoPedido> findByEstado(boolean estado);
}
