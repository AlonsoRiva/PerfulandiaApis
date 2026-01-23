package com.example.PerfulandiaApiSucursales.models.entities;

import com.example.PerfulandiaApiSucursales.models.request.AgregarSucursal;

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
    private int personalAsignado; 

    @Column(nullable = false) 
    private String politicas;

    public static Sucursal crearSucursal(AgregarSucursal request) {
        Sucursal sucursal = new Sucursal();
        sucursal.setNombre(request.getNombre());
        sucursal.setDireccion(request.getDireccion());
        sucursal.setHorarioAtencion(request.getHorarioAtencion());
        sucursal.setPersonalAsignado(request.getPersonalAsignado());
        sucursal.setPoliticas(request.getPoliticas());
        return sucursal;
    } 
}