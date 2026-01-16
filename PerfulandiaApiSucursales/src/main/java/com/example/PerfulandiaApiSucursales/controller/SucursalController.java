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
@RequestMapping("/pfl_sucursales")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @GetMapping("")
    public List<Sucursal> obtenerTodas() {
        return sucursalService.listarTodo();
    }

    @GetMapping("/{id}")
    public Sucursal obtenerPorId(@PathVariable int id) {
        return sucursalService.obtenerPorId(id);
    }

    @PostMapping("")
    public Sucursal crear(@Valid @RequestBody AgregarSucursal nueva) {
        return sucursalService.agregar(nueva);
    }

    @PutMapping("")
    public Sucursal actualizar(@RequestBody ActualizarSucursal actualizacion) {
        return sucursalService.actualizar(actualizacion);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        return sucursalService.eliminar(id);
    }
}