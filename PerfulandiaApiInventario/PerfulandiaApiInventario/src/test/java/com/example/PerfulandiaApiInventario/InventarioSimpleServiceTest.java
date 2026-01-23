package com.example.PerfulandiaApiInventario;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.PerfulandiaApiInventario.models.entities.Inventario;
import com.example.PerfulandiaApiInventario.models.request.AgregarInventario;
import com.example.PerfulandiaApiInventario.services.InventarioSimpleService;

public class InventarioSimpleServiceTest {

    private final InventarioSimpleService inventarioService =
            new InventarioSimpleService();

    @Test
    void probandoCreacionDeInventario() {

        AgregarInventario request = new AgregarInventario();
        request.setNombre("Perfume Test");
        request.setGenero("Unisex");
        request.setPrecio(19990);
        request.setStock(50);

        Inventario resultado = inventarioService.crearInventario(request);

        assertEquals("Perfume Test", resultado.getNombre());
        assertEquals(19990, resultado.getPrecio());
        assertEquals(50, resultado.getStock());
    }
}

