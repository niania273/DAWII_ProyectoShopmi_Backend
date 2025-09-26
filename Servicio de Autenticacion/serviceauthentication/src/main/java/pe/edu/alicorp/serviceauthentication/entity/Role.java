package pe.edu.alicorp.serviceauthentication.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name="ROL")
@Getter @Setter @NoArgsConstructor
public class Role {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CODROL") private Integer id;
    @Column(name="NOMBREROL", nullable=false) private String name;
    @Column(name="ESTROL",    nullable=false) private Integer status = 1;
}