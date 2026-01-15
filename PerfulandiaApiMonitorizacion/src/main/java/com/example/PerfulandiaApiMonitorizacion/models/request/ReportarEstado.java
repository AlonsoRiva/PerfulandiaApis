package com.example.PerfulandiaApiMonitorizacion.models.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ReportarEstado {
    @NotBlank(message = "El estado no puede estar vacío")
    private String estado;

    @Min(0) @Max(100)
    private Integer usoCpu;

    @Min(0) @Max(100)
    private Integer usoMemoria;

    private String mensaje;
}