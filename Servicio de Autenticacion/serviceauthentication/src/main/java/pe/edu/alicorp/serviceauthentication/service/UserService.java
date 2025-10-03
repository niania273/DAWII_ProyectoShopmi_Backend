/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.alicorp.serviceauthentication.service;

/**
 *
 * @author SUITE
 */

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.alicorp.serviceauthentication.entity.Role;
import pe.edu.alicorp.serviceauthentication.entity.User;
import pe.edu.alicorp.serviceauthentication.repository.RoleRepository;
import pe.edu.alicorp.serviceauthentication.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    // Crear usuario
    public User create(User user) {
        return userRepository.save(user);
    }

    // Buscar usuario por ID
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    // Buscar por email (ejemplo para login)
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Listar todos los usuarios
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // Eliminar usuario
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    // Consultar rol de un usuario
    public String getUserRole(Integer userId) {
        var user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Role role = user.getRole();
        return role != null ? role.getName() : null;
    }
}

