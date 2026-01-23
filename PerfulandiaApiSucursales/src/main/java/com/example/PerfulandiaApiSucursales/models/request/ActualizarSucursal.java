package com.example.PerfulandiaApiSucursales.models.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ActualizarSucursal {
    @Min(1)
    private int id_sucursal;

    @NotBlank
    private String nombre;

    @NotBlank
    private String direccion;

    @NotBlank
    private String horarioAtencion;

    private int personalAsignado;

    @NotBlank
    private String politicas;
}