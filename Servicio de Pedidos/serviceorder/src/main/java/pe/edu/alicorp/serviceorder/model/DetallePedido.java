package pe.edu.alicorp.serviceorder.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table( name = "DETALLEPEDIDO")
@Data
public class DetallePedido {
    @EmbeddedId
    private DetallePedidoId id;
    @MapsId("codpedido")
    private Pedido pedido;
    private int codProducto;
    @Column(name = "PREUNI", nullable = false, precision = 10, scale = 2)
    private double preUni;
    @Column(name = "CANTIDAD", nullable = false)
    private int cantidad;
    @Column(name = "FECHACREACION")
    private LocalDateTime fechaCreacion;
    @Column(name = "FECHAACTUALIZA")
    private LocalDateTime fechaActualiza;
}
