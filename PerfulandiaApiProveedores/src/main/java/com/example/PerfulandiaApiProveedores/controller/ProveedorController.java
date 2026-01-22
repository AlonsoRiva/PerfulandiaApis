package com.example.PerfulandiaApiProveedores.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import com.example.PerfulandiaApiProveedores.models.entities.Proveedor;
import com.example.PerfulandiaApiProveedores.models.request.ActualizarProveedor;
import com.example.PerfulandiaApiProveedores.models.request.AgregarProveedor;
import com.example.PerfulandiaApiProveedores.services.ProveedorService;

@RestController
@RequestMapping("/proveedores") // 
public class ProveedorController {

    @Autowired
    private ProveedorService service;


    @GetMapping("")
    public List<Proveedor> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Proveedor obtener(@PathVariable int id) {
        return service.obtenerPorId(id);
    }


    @PostMapping("")
    public Proveedor crear(@Valid @RequestBody AgregarProveedor request) {
        return service.crear(request);
    }

    @PutMapping("")
    public Proveedor actualizar(@Valid @RequestBody ActualizarProveedor request) {
        return service.actualizar(request);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        return service.eliminar(id);
    }
}