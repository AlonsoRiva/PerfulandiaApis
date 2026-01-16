package com.example.PerfulandiaApiRutas.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "rutas_entrega")
public class RutaEntrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_ruta;

    @Column(nullable = false)
    private String zona; 

    @Column(nullable = false)
    private String patenteVehiculo; 

    @Column(nullable = false)
    private String nombreConductor; 

    @Column(nullable = false) 
    private int cantidadPedidos; 

    @Column(nullable = false)
    private String prioridad; 

    @Column(nullable = false)
    private String estado; 
    
    private LocalDateTime fechaSalida; 
}