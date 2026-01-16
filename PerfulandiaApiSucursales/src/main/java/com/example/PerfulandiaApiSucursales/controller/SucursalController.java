package com.example.PerfulandiaApiSucursales.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import com.example.PerfulandiaApiSucursales.models.entities.Sucursal;
import com.example.PerfulandiaApiSucursales.models.request.ActualizarSucursal;
import com.example.PerfulandiaApiSucursales.models.request.AgregarSucursal;
import com.example.PerfulandiaApiSucursales.service.SucursalService;

@RestController
@RequestMapping("/sucursales")
public class SucursalController {

    @Autowired
    private SucursalService service;

    @GetMapping("")
    public List<Sucursal> listar() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public Sucursal obtener(@PathVariable int id) {
        return service.obtenerPorId(id);
    }

    @PostMapping("")
    public Sucursal crear(@Valid @RequestBody AgregarSucursal sucursal) {
        return service.crear(sucursal);
    }

    @PutMapping("")
    public Sucursal actualizar(@Valid @RequestBody ActualizarSucursal sucursal) {
        return service.actualizar(sucursal);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        return service.eliminar(id);
    }
}