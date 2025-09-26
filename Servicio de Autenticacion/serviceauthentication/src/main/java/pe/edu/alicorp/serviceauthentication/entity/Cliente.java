package pe.edu.alicorp.serviceauthentication.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="CLIENTE")
@Getter @Setter @NoArgsConstructor
public class Cliente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CODCLIENTE") private Integer codcliente;

    @Column(name="RAZSOCIAL", nullable=false)  private String razsocial;
    @Column(name="NRODOC",    nullable=false)  private String nrodoc;
    @Column(name="CORCLIENTE")                 private String corcliente;
    @Column(name="ESTCLIENTE", nullable=false) private Integer estcliente = 1;
}