package com.example.PerfulandiaApiRespaldos.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CrearRespaldo {
    
    @NotBlank(message = "El nombre del archivo es obligatorio")
    private String nombreArchivo;

    @NotBlank(message = "La fecha es obligatoria")
    private String fecha;

    @NotBlank(message = "El tipo es obligatorio")
    private String tipo;
}