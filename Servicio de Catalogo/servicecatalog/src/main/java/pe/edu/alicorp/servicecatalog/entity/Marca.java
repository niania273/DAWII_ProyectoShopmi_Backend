/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
/**
 *
 * @author USER
 */
package pe.edu.alicorp.servicecatalog.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "MARCA")
@Data
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODMARCA")
    private Long id;

    @Column(name = "IMGMARCA", nullable = false, length = 50)
    private String img;

    @Column(name = "NOMBREMARCA", nullable = false, length = 25)
    private String nombre;

    @Column(name = "ESTMARCA", nullable = false)
    private Byte estado; // 1 activo, 0 inactivo

    @Column(name = "FECHACREACION", insertable = false, updatable = false)
    private Timestamp creado;

    @Column(name = "FECHAACTUALIZA", insertable = false)
    private Timestamp actualizado;
}
