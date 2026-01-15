package com.example.PerfulandiaApiProveedores.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ActualizarProveedor {
    private int id_proveedor;

    @NotBlank
    private String nombreEmpresa;

    @NotBlank
    private String contactoNombre;

    @NotBlank
    private String telefono;

    @NotBlank
    private String email;

}