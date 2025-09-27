package pe.edu.alicorp.serviceorder.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "PEDIDO")
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codpedido;
    @Column(name = "CODUSUARIO", nullable = false)
    private Long codusuario;

    @Column(name = "FECPED", nullable = false)
    private LocalDateTime fecped;

    @Column(name = "PRECIOTOTAL", nullable = false, precision = 10, scale = 2)
    private double preciototal;

    @Column(name = "CODESTADO", nullable = false)
    private Long codEstado;

    @Column(name = "ESTPED", nullable = false)
    private boolean estped;

    @Column(name = "FECHACREACION", updatable = false, insertable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "FECHAACTUALIZA", insertable = false)
    private LocalDateTime fechaActualiza;

}
