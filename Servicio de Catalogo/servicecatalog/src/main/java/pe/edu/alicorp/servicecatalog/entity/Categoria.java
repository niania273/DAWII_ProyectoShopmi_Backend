package pe.edu.alicorp.servicecatalog.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "CATEGORIA")
@Data
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODCATEGORIA")
    private Long id;

    @Column(name = "IMGCATEGORIA", nullable = false, length = 50)
    private String img;

    @Column(name = "NOMCATEGORIA", nullable = false, length = 50)
    private String nombre;

    @Column(name = "ESTCATEGORIA", nullable = false)
    private Byte estado;

    @Column(name = "FECHACREACION", insertable = false, updatable = false)
    private Timestamp creado;

    @Column(name = "FECHAACTUALIZA", insertable = false)
    private Timestamp actualizado;

}
