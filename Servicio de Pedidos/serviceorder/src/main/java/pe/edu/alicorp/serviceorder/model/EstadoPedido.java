package pe.edu.alicorp.serviceorder.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ESTADO_PEDIDO")
@Data
public class EstadoPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODESTADO")
    private Long codEstado;
    @Column(name = "NOMESTADO", nullable = false, length = 50)
    private String nomEstado;
}
