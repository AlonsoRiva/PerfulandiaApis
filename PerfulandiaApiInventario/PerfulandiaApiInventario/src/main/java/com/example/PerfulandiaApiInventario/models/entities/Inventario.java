package com.example.PerfulandiaApiInventario.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "inventario")
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_producto;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String genero;
    
    @Column(nullable = false)
    private int precio;

    @Column(nullable = false)
    private int stock;
}
