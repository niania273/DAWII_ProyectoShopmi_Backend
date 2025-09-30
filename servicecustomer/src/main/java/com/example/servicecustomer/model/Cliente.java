/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.servicecustomer.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODCLIENTE")
    private Long codCliente;

    @Column(name = "RAZSOCIAL", nullable = false)
    private String razSocial;

    @Column(name = "NRODOC", nullable = false)
    private String nroDoc;

    @Column(name = "CORCLIENTE")
    private String corCliente;

    @Column(name = "ESTCLIENTE", nullable = false)
    private Boolean estCliente;
}

