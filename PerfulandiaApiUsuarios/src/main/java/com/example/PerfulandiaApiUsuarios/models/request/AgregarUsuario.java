package com.example.PerfulandiaApiUsuarios.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AgregarUsuario {
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private int id_permiso;
    
}
