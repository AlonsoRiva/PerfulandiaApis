package com.example.PerfulandiaApiPedidos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.PerfulandiaApiPedidos.models.entities.Pedidos;
import com.example.PerfulandiaApiPedidos.models.request.CrearPedido;
import com.example.PerfulandiaApiPedidos.service.PedidoPruebaService;

public class PedidoPruebaServiceTest {

    private final PedidoPruebaService pedidoService =
            new PedidoPruebaService();

    @Test
    void probandoCreacionDePedidoPendiente() {

        CrearPedido request = new CrearPedido();
        request.setIdSucursal(3);
        request.setDetalleProductos("Perfume A x10, Perfume B x5");

        Pedidos resultado = pedidoService.crearPedido(request);

        assertEquals(3, resultado.getIdSucursal());
        assertEquals("PENDIENTE", resultado.getEstado());
    }
}
