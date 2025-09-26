package pe.edu.alicorp.serviceorder.model;

import jakarta.persistence.Column;

import java.io.Serializable;

public class DetallePedidoId implements Serializable {

    @Column(name = "CODPEDIDO")
    private Long codpedido;
    @Column(name = "CODPRODUCTO")
    private Long codproducto;
}
