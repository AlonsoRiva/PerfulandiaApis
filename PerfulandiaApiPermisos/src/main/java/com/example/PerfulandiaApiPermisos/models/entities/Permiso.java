package com.example.PerfulandiaApiPermisos.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "pfl_permisos")
public class Permiso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_permiso;

    @Column(nullable = false, unique = true)
    private String nombre; 

    @Column(nullable = false)
    private String modulo; //Esto se refiere al area por ejemplo ventas o seguridad o inventario
    
    @Column(nullable = false)
    private String descripcion; // una breve descripcion del modulo 
}