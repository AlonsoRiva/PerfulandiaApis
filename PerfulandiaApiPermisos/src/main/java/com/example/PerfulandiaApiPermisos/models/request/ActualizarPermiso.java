package com.example.PerfulandiaApiPermisos.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ActualizarPermiso {
    private int id_permiso;
    @NotBlank
    private String nombre;
    @NotBlank
    private String modulo;
    private String descripcion;
}