package com.example.PerfulandiaApiRutas.models.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class PlanificarRuta {
    
    @NotBlank
    private String zona;

    @NotBlank
    private String patenteVehiculo;

    @NotBlank
    private String nombreConductor;

    @Min(1)
    private int cantidadPedidos;

    @NotBlank
    private String prioridad;
    
    private LocalDateTime fechaSalida;
}