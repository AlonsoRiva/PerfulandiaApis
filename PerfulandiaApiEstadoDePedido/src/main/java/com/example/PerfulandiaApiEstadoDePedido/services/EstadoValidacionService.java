package com.example.PerfulandiaApiEstadoDePedido.services;

import org.springframework.stereotype.Service;
import com.example.PerfulandiaApiEstadoDePedido.models.entities.EstadoPedido;

@Service
public class EstadoValidacionService {

    // Regla: El registro es válido si tiene ID de pedido y nombre del producto
    public boolean esRegistroCompleto(EstadoPedido pedido) {
        if (pedido == null) return false;

        return pedido.getPedidoId() > 0 && 
               pedido.getNombreProducto() != null && 
               !pedido.getNombreProducto().isBlank();
    }
}