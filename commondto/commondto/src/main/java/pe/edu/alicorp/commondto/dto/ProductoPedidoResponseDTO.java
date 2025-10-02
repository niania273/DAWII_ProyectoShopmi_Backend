package pe.edu.alicorp.commondto.dto;

public class ProductoPedidoResponseDTO {

    private String imgProducto;
    private String nomProducto;
    private double preUni;
    private int cantidad;

    public ProductoPedidoResponseDTO() {
    }

    public ProductoPedidoResponseDTO(String imgProducto, String nomProducto, double preUni, int cantidad) {
        this.imgProducto = imgProducto;
        this.nomProducto = nomProducto;
        this.preUni = preUni;
        this.cantidad = cantidad;
    }

    public String getImgProducto() {
        return imgProducto;
    }

    public void setImgProducto(String imgProducto) {
        this.imgProducto = imgProducto;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

    public double getPreUni() {
        return preUni;
    }

    public void setPreUni(double preUni) {
        this.preUni = preUni;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
