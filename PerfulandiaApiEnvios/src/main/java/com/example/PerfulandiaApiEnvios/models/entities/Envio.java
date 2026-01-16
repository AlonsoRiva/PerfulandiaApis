package com.example.PerfulandiaApiEnvios.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "envios")
public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_envio;

    @Column(nullable = false)
    private String origen; 

    private Integer idSucursalDestino; 

    private String direccionCliente; 

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private String estado; // "DESPACHADO", "EN_CAMINO", "ENTREGADO"
}