package com.example.PerfulandiaApiInventario.models.request;

import lombok.Data;

@Data
public class ActualizarInventario {
    private int id_producto;
    private int cantidad; 
}