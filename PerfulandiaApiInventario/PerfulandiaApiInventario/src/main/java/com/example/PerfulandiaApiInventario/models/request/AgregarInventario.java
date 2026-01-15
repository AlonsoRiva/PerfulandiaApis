package com.example.PerfulandiaApiInventario.models.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AgregarInventario {
    @NotBlank
    private String nombre;
    
    @NotBlank
    private String genero;
    
    @NotNull
    private int precio;
    
    @NotNull
    private int stock;
}