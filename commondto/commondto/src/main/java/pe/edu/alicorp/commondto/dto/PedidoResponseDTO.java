package pe.edu.alicorp.commondto.dto;

import java.time.LocalDateTime;

public class PedidoResponseDTO {

    private Long codPedido;
    private LocalDateTime fecPed;
    private String cliente;
    private double precioTotal;
    private int codEstado;
    private String nomEstado;
    private int cantidadTotal;
    private boolean estPed;

    public Long getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(Long codPedido) {
        this.codPedido = codPedido;
    }

    public LocalDateTime getFecPed() {
        return fecPed;
    }

    public void setFecPed(LocalDateTime fecPed) {
        this.fecPed = fecPed;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public int getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(int codEstado) {
        this.codEstado = codEstado;
    }

    public String getNomEstado() {
        return nomEstado;
    }

    public void setNomEstado(String nomEstado) {
        this.nomEstado = nomEstado;
    }

    public int getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(int cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

    public boolean isEstPed() {
        return estPed;
    }

    public void setEstPed(boolean estPed) {
        this.estPed = estPed;
    }
}
