package com.example.PerfulandiaApiInventario.services;

import com.example.PerfulandiaApiInventario.models.entities.Inventario;
import com.example.PerfulandiaApiInventario.models.request.AgregarInventario;

public class InventarioSimpleService {

    public Inventario crearInventario(AgregarInventario request) {

        Inventario inventario = new Inventario();
        inventario.setNombre(request.getNombre());
        inventario.setGenero(request.getGenero());
        inventario.setPrecio(request.getPrecio());
        inventario.setStock(request.getStock());

        return inventario;
    }
}
