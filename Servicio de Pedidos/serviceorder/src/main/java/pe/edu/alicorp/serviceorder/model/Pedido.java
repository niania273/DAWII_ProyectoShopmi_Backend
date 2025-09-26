package pe.edu.alicorp.serviceorder.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "PEDIDO")
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codpedido;
    private Long codcliente;
    private LocalDate fecped;
    private double preciototal;
    private Long codestado;
    private boolean estped;

}
