package pe.edu.alicorp.serviceauthentication.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "USUARIO")
@Getter @Setter @NoArgsConstructor
@ToString(exclude = "passwordHash")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODUSUARIO")
    private Integer id;

    @Column(name = "APEUSUARIO", nullable = false, length = 50)
    private String lastName;

    @Column(name = "NOMUSUARIO", nullable = false, length = 50)
    private String firstName;

    @Column(name = "FECNAC", nullable = false)
    private LocalDate birthDate;

    @Column(name = "SEXUSUARIO", nullable = false, length = 1)
    private String sex; // 'M' o 'F'

    @Column(name = "TELUSUARIO", nullable = false, length = 9)
    private String phone; // 9 dígitos

    @Column(name = "CORUSUARIO", nullable = false, unique = true, length = 120)
    private String email;

    @Column(name = "CONUSUARIO", nullable = false, length = 100)
    private String passwordHash; // BCrypt ~60 chars

    // Usamos el DEFAULT CURRENT_TIMESTAMP de la BD (no lo escribimos desde la app)
    @Column(name = "FECCRE", nullable = false, insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "ESTUSUARIO", nullable = false)
    private Integer status = 1;

    // En tu BD hay FK a CLIENTE; aquí lo mantenemos como referencia lógica (int)
    @Column(name = "CODCLIENTE", nullable = false)
    private Integer codCliente;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "CODROL", nullable = false)
    private Role role;
}
