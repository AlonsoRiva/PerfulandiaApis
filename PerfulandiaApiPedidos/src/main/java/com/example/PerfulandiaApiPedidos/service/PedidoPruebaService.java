package com.example.PerfulandiaApiPedidos.service;

import com.example.PerfulandiaApiPedidos.models.entities.Pedidos;
import com.example.PerfulandiaApiPedidos.models.request.CrearPedido;

public class PedidoPruebaService {

    public Pedidos crearPedido(CrearPedido request) {

        Pedidos pedido = new Pedidos();
        pedido.setIdSucursal(request.getIdSucursal());
        pedido.setDetalle_productos(request.getDetalleProductos());
        pedido.setEstado("PENDIENTE"); // estado inicial

        return pedido;
    }
}
