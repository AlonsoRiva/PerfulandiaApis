package com.example.PerfulandiaApiSucursales.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AgregarSucursal {
    @NotBlank
    private String nombre;
    
    @NotBlank
    private String direccion;
    
    @NotBlank
    private String horarioApertura;
    
    private String personalAsignado;
    
    private String politicasLocales;
}