package com.example.PerfulandiaApiRutas.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import com.example.PerfulandiaApiRutas.models.entities.RutaEntrega;
import com.example.PerfulandiaApiRutas.models.request.ActualizarRuta;
import com.example.PerfulandiaApiRutas.models.request.PlanificarRuta;
import com.example.PerfulandiaApiRutas.services.RutaService;

@RestController
@RequestMapping("/rutas_entrega")
public class RutaController {

    @Autowired
    private RutaService service;

    @GetMapping("")
    public List<RutaEntrega> listar() {
        return service.listarTodas();
    }

    @PostMapping("")
    public RutaEntrega crear(@Valid @RequestBody PlanificarRuta nuevo) {
        return service.crear(nuevo);
    }

    @PutMapping("/{id}")
    public RutaEntrega actualizar(@PathVariable int id, @Valid @RequestBody ActualizarRuta datos) {
        return service.actualizarRuta(id, datos);
    }

    @PutMapping("/optimizar/{id}")
    public RutaEntrega optimizar(@PathVariable int id) {
        return service.optimizarRuta(id);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        return service.eliminar(id);
    }
}