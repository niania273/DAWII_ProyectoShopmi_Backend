package pe.edu.alicorp.serviceauthentication.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.alicorp.serviceauthentication.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}