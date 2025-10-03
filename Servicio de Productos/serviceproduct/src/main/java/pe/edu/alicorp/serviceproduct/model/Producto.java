package pe.edu.alicorp.serviceproduct.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "PRODUCTO")
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODPRODUCTO")
    private long codproducto;

    @Column(name = "CODCATEGORIA", nullable = false)
    private long codcategoria;

    @Column(name = "IMGPRODUCTO", length = 50, nullable = false)
    private String imgproducto;

    @Column(name = "NOMPRODUCTO", length = 70, nullable = false)
    private String nomproducto;

    @Column(name = "DESCRIPCION", length = 300, nullable = false)
    private String descripcion;

    @Column(name = "PREUNI", nullable = false)
    private double preuni;

    @Column(name = "CODMARCA", nullable = false)
    private long codmarca;

    @Column(name = "STOCK",nullable = false)
    private int stock;

    @Column(name = "ESTPRODUCTO", nullable = false)
    private boolean estproducto;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    @Column(name = "FECHACREACION")
    private LocalDateTime fechacreacion;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    @Column(name = "FECHAACTUALIZA")
    private LocalDateTime fechaactualiza;

    public void actualizarProducto(Producto nuevoProducto) {
        this.codcategoria = nuevoProducto.getCodcategoria();
        this.imgproducto = nuevoProducto.getImgproducto();
        this.nomproducto = nuevoProducto.getNomproducto();
        this.descripcion = nuevoProducto.getDescripcion();
        this.preuni = nuevoProducto.getPreuni();
        this.codmarca = nuevoProducto.getCodmarca();
        this.stock = nuevoProducto.getStock();
        this.estproducto = nuevoProducto.isEstproducto();
    }
}

