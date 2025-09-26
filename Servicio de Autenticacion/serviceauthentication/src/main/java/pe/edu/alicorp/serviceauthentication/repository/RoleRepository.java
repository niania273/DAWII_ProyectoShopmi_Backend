package pe.edu.alicorp.serviceauthentication.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.alicorp.serviceauthentication.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {}