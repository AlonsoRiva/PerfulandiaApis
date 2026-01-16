package com.example.PerfulandiaApiSucursales.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AgregarSucursal {
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "La dirección es obligatoria")
    private String direccion;

    @NotBlank(message = "El horario es obligatorio")
    private String horarioAtencion;

    @NotBlank(message = "Debe indicar el personal asignado")
    private String personalAsignado;

    @NotBlank(message = "Las políticas son obligatorias")
    private String politicas;
}