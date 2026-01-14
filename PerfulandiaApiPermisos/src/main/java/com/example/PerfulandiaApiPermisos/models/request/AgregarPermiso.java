package com.example.PerfulandiaApiPermisos.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AgregarPermiso {
    @NotBlank
    private String nombre;
    @NotBlank
    private String modulo;
    private String descripcion;
}