package com.example.PerfulandiaApiRespaldos.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "respaldos")
public class Respaldo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_respaldo;

    @Column(nullable = false)
    private String nombreArchivo; 

    @Column(nullable = false)
    private String fecha; 

    @Column(nullable = false)
    private String tipo; 

    @Column(nullable = false)
    private String estado; 
}