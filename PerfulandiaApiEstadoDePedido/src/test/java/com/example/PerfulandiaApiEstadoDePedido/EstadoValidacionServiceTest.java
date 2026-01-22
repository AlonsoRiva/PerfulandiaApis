package com.example.PerfulandiaApiEstadoDePedido;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.PerfulandiaApiEstadoDePedido.models.entities.EstadoPedido;
import com.example.PerfulandiaApiEstadoDePedido.services.EstadoValidacionService;

@ExtendWith(MockitoExtension.class)
public class EstadoValidacionServiceTest {

    private final EstadoValidacionService servicio = new EstadoValidacionService();

    @Test
    void pruebaPedidoCompleto() {
        // Caso: Tiene ID de pedido y nombre de producto -> TRUE
        EstadoPedido pedido = new EstadoPedido();
        pedido.setPedidoId(500);
        pedido.setNombreProducto("Perfume Invictus");

        assertThat(servicio.esRegistroCompleto(pedido)).isTrue();
    }

    @Test
    void pruebaPedidoIncompleto() {
        // Caso: No tiene nombre de producto -> FALSE
        EstadoPedido pedido = new EstadoPedido();
        pedido.setPedidoId(500);
        pedido.setNombreProducto(""); 

        assertThat(servicio.esRegistroCompleto(pedido)).isFalse();
    }
}