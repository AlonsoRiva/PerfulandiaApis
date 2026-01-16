package com.example.PerfulandiaApiEnvios.models.request;

import lombok.Data;

@Data
public class CrearEnvio {
    private String origen;
    private Integer idSucursalDestino;
    private String direccionCliente;
    private String descripcion;
}