package com.example.PerfulandiaApiPedidos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import com.example.PerfulandiaApiPedidos.models.entities.Pedidos;
import com.example.PerfulandiaApiPedidos.models.request.AutorizarPedidos;
import com.example.PerfulandiaApiPedidos.models.request.CrearPedido;
import com.example.PerfulandiaApiPedidos.service.PedidoService;

@RestController
@RequestMapping("/pfl_pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    // Listar todos (Supervisión general)
    @GetMapping("")
    public List<Pedidos> listarTodos() {
        return pedidoService.listarTodos();
    }
    
    // Listar solo pendientes (Para que el gerente vea qué falta aprobar)
    @GetMapping("/pendientes")
    public List<Pedidos> listarPendientes() {
        return pedidoService.listarPendientes();
    }

    @GetMapping("/{id}")
    public Pedidos obtenerPorId(@PathVariable int id) {
        return pedidoService.obtenerPorId(id);
    }

    // Crear solicitud de pedido
    @PostMapping("")
    public Pedidos crear(@Valid @RequestBody CrearPedido request) {
        return pedidoService.crear(request);
    }

    // AUTORIZAR o RECHAZAR pedido
    @PutMapping("/{id}/autorizar")
    public Pedidos autorizar(@PathVariable int id, @RequestBody AutorizarPedidos request) {
        return pedidoService.cambiarEstado(id, request.getNuevoEstado());
    }
}