package pe.edu.alicorp.serviceorder.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.MapsId;

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
}
