package pe.edu.alicorp.serviceauthentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.alicorp.serviceauthentication.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    boolean existsByNrodoc(String nrodoc);
    boolean existsByCorcliente(String correo);
}