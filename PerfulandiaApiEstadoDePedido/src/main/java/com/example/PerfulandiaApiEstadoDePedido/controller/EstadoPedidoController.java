package com.example.PerfulandiaApiEstadoDePedido.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.PerfulandiaApiEstadoDePedido.models.entities.EstadoPedido;
import com.example.PerfulandiaApiEstadoDePedido.services.EstadoPedidoService; 

@RestController
@RequestMapping("/estado_pedidos")
public class EstadoPedidoController {

    @Autowired
    private EstadoPedidoService service;

    @GetMapping("")
    public List<EstadoPedido> listar() {
        return service.obtenerTodos();
    }

    @PostMapping("")
    public EstadoPedido crear(@RequestBody EstadoPedido estadoPedido) {
        return service.registrarEstado(estadoPedido);
    }

    @PutMapping("/{id}")
    public EstadoPedido actualizar(@PathVariable int id, @RequestParam String estado) {
        return service.actualizarEstado(id, estado);
    }
}