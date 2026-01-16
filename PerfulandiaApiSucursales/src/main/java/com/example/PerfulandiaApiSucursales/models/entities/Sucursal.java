package com.example.PerfulandiaApiSucursales.models.entities;

import java.util.List;

import com.example.PerfulandiaApiSucursales.models.request.ActualizarSucursal;
import com.example.PerfulandiaApiSucursales.models.request.AgregarSucursal;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "pfl_sucursales")
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_sucursal;

    @Column(nullable = false)
    private String nombre; // Ej: "Sucursal Viña del Mar"

    @Column(nullable = false)
    private String direccion;

    @Column(name = "horario_apertura", nullable = false)
    private String horarioApertura; // Ej: "Lun-Vie 09:00 - 18:00"

    @Column(name = "personal_asignado")
    private String personalAsignado; // Ej: "Juan Perez (Gerente), Maria (Ventas)" o IDs de usuarios

    @Column(name = "politicas_locales", length = 1000)
    private String politicasLocales; // Ej: "No se aceptan devoluciones sin boleta"

    public List<Sucursal> listarTodo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("enlistar todos los objetos");
    }

    public Sucursal obtenerPorId(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("agregar por id");
    }

    public Sucursal agregar(AgregarSucursal nueva) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("agregar");
    }

    public Sucursal actualizar(ActualizarSucursal actualizacion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("actualizar");
    }

    public String eliminar(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Eliminar por id");
    }
}
