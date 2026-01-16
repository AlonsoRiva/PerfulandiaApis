package com.example.PerfulandiaApiSucursales.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "sucursales")
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_sucursal;

    @Column(nullable = false)
    private String nombre; 

    @Column(nullable = false)
    private String direccion; 
    
    @Column(name = "horario_atencion", nullable = false)
    private String horarioAtencion; 

    @Column(name = "personal_asignado", nullable = false)
    private String personalAsignado; 

    @Column(nullable = false) 
    private String politicas; 
}