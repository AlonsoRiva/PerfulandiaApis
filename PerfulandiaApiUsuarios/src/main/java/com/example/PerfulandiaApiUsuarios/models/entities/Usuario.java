package com.example.PerfulandiaApiUsuarios.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "pfl_usuarios")


public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;


    @Column(nullable = false)
    private String nombre;


    @Column(nullable = false)
    private String apellido;


    @Column(nullable = false, unique = true)


    private String email;


    @Column(nullable = false)
    private String password;


}
