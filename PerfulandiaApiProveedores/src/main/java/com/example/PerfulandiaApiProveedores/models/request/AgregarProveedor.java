package com.example.PerfulandiaApiProveedores.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AgregarProveedor {
    @NotBlank
    private String nombreEmpresa;

    @NotBlank
    private String contactoNombre;

    @NotBlank
    private String telefono;

    @NotBlank
    private String email;

}