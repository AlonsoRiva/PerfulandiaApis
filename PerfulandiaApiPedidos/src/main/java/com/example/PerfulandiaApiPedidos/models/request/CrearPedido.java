package com.example.PerfulandiaApiPedidos.models.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CrearPedido {
    @NotNull
    private Integer idSucursal;

    @NotBlank
    private String detalleProductos;
}