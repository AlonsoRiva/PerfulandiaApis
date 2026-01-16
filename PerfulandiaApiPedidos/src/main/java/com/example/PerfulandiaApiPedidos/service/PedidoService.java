package com.example.PerfulandiaApiPedidos.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.PerfulandiaApiPedidos.models.entities.Pedidos;
import com.example.PerfulandiaApiPedidos.models.request.CrearPedido;
import com.example.PerfulandiaApiPedidos.repositories.PedidoRepositorio;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    public List<Pedidos> listarTodos() {
        return pedidoRepositorio.findAll();
    }
    
    public List<Pedidos> listarPendientes() {
        return pedidoRepositorio.findByEstado("PENDIENTE");
    }

    public Pedidos obtenerPorId(int id) {
        return pedidoRepositorio.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido no encontrado"));
    }

    // Acción 1: Solicitar reabastecimiento
    public Pedidos crear(CrearPedido request) {
        Pedidos nuevo = new Pedidos();
        nuevo.setIdSucursal(request.getIdSucursal());
        nuevo.setDetalle_productos(request.getDetalleProductos());
        nuevo.setEstado("PENDIENTE"); // Siempre inicia pendiente
        
        return pedidoRepositorio.save(nuevo);
    }

    // Acción 2: Autorizar o Rechazar (La función del Gerente)
    public Pedidos cambiarEstado(int id, String nuevoEstado) {
        Pedidos pedido = obtenerPorId(id);
        
        pedido.setEstado(nuevoEstado.toUpperCase());
        pedido.setFechaAutorizacion(LocalDateTime.now());
        
        return pedidoRepositorio.save(pedido);
    }
}