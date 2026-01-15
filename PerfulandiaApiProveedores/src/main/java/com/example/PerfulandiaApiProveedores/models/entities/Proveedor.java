package com.example.PerfulandiaApiProveedores.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "proveedores") 
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_proveedor;

    @Column(nullable = false, unique = true)
    private String nombreEmpresa;  

    @Column(nullable = false)
    private String contactoNombre; 

    @Column(nullable = false)
    private String telefono;

    @Column(nullable = false)
    private String email;
}