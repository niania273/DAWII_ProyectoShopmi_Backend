package pe.edu.alicorp.commondto.dto;

import java.time.LocalDate;

public class PedidoDTO {

    private Long codPedido;
    private String cliente;
    private LocalDate fecPed;
    private double precioTotal;
    private Long codEstado;
    private String nomEstado;
    private boolean estPed;
}
