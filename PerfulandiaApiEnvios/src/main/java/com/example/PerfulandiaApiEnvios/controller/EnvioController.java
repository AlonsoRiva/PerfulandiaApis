package com.example.PerfulandiaApiEnvios.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.PerfulandiaApiEnvios.models.entities.Envio;
import com.example.PerfulandiaApiEnvios.models.request.CrearEnvio;
import com.example.PerfulandiaApiEnvios.services.EnvioService;

@RestController
@RequestMapping("/envios")
public class EnvioController {

    @Autowired
    private EnvioService service;

    @GetMapping("")
    public List<Envio> listar() {
        return service.listarTodos();
    }

    @PostMapping("")
    public Envio crear(@RequestBody CrearEnvio envio) {
        return service.crearEnvio(envio);
    }

    @PutMapping("/{id}/estado")
    public Envio actualizar(@PathVariable int id, @RequestParam String estado) {
        return service.actualizarEstado(id, estado);
    }
}