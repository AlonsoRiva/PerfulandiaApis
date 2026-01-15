package com.example.PerfulandiaApiInventario.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import com.example.PerfulandiaApiInventario.models.entities.Inventario;
import com.example.PerfulandiaApiInventario.models.request.AgregarInventario;
import com.example.PerfulandiaApiInventario.services.InventarioService;

@RestController
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @GetMapping("")
    public List<Inventario> obtenerTodos() {
        return inventarioService.listarTodo();
    }

    @GetMapping("/{id}")
    public Inventario obtenerPorId(@PathVariable int id) {
        return inventarioService.obtenerPorId(id);
    }

    @PostMapping("")
    public Inventario crear(@Valid @RequestBody AgregarInventario nuevo) {
        return inventarioService.agregar(nuevo);
    }
    
    @PutMapping("/{id}")
    public Inventario editar(@PathVariable int id, @Valid @RequestBody AgregarInventario datos) {
        return inventarioService.actualizar(id, datos);
    }

    
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        return inventarioService.eliminar(id);
    }
}