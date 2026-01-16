package com.example.PerfulandiaApiPedidos.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AutorizarPedidos {
    // Solo necesitamos saber a qué estado pasa (AUTORIZADO o RECHAZADO)
    @NotBlank
    private String nuevoEstado; 
}