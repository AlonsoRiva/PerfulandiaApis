package com.example.PerfulandiaApiEstadoDePedido.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.*;

import com.example.PerfulandiaApiEstadoDePedido.models.entities.EstadoPedido;
import com.example.PerfulandiaApiEstadoDePedido.services.EstadoPedidoService; 

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/estado_pedidos")
public class EstadoPedidoController {

    @Autowired
    private EstadoPedidoService service;

    @GetMapping("")
    public List<EstadoPedido> obtenerTodos() {
        return service.obtenerTodos();
    }

    @GetMapping("/{id}")
    public EntityModel<EstadoPedido> obtenerPorId(@PathVariable int id) {
        EstadoPedido estadoPedido = service.obtenerPorId(id);
        
        Link deleteLink = linkTo(EstadoPedidoController.class).slash(id).withRel("Eliminar estado");
        Link selfLink = linkTo(methodOn(EstadoPedidoController.class).obtenerTodos()).withRel("Obtener todos los estados");
        
        return EntityModel.of(estadoPedido, selfLink, deleteLink);
    }

    // 3. Crear registro
    @PostMapping("")
    public EstadoPedido registrarEstado(@RequestBody EstadoPedido estadoPedido) {
        return service.registrarEstado(estadoPedido);
    }

    // 4. Actualizar estado
    @PutMapping("/{id}")
    public EstadoPedido actualizarEstado(@PathVariable int id, @RequestParam String estado) {
        return service.actualizarEstado(id, estado);
    }

}