package pe.edu.alicorp.serviceauthentication.service;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import pe.edu.alicorp.serviceauthentication.entity.User;
import pe.edu.alicorp.serviceauthentication.repository.UserRepository;

@Service @RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User u = repo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("No existe usuario"));
        String role = u.getRole()!=null ? u.getRole().getName() : "USER";
        return org.springframework.security.core.userdetails.User
                .withUsername(u.getEmail())
                .password(u.getPasswordHash())
                .roles(role)
                .build();
    }
}