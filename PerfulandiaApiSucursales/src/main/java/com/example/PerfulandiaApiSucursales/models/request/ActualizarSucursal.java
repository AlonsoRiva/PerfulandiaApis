package com.example.PerfulandiaApiSucursales.models.request;

import lombok.Data;

@Data
public class ActualizarSucursal {
    private int id_sucursal;
    private String nombre;
    private String direccion;
    private String horarioApertura;
    private String personalAsignado;
    private String politicasLocales;
}