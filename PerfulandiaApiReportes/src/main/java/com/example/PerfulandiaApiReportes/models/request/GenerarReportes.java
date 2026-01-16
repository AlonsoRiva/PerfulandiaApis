package com.example.PerfulandiaApiReportes.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class GenerarReportes {
    
    @NotBlank
    private String tipoReporte; // VENTAS, INVENTARIO, RENDIMIENTO
    
    private Integer idSucursal; // ID de la sucursal sobre la cual se quiere el reporte
    
    private String periodo; // Ej: "MENSUAL", "SEMANAL"
}