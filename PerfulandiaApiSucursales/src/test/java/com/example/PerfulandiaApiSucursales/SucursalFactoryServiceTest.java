package com.example.PerfulandiaApiSucursales;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.PerfulandiaApiSucursales.models.entities.Sucursal;
import com.example.PerfulandiaApiSucursales.models.request.AgregarSucursal;
import com.example.PerfulandiaApiSucursales.service.SucursalService;

public class SucursalFactoryServiceTest {

    private final SucursalService sucursalService =
            new SucursalService();

    @Test
    void probandoCreacionDeSucursal() {

        AgregarSucursal request = new AgregarSucursal();
        request.setNombre("Sucursal Centro");
        request.setDireccion("Av. Principal 123");
        request.setHorarioAtencion("09:00 - 18:00");
        request.setPersonalAsignado(10);
        request.setPoliticas("No devoluciones");

        Sucursal resultado = Sucursal.crearSucursal(request);

        assertEquals("Sucursal Centro", resultado.getNombre());
        assertEquals("Av. Principal 123", resultado.getDireccion());
        assertEquals(10, resultado.getPersonalAsignado());
    }
}
