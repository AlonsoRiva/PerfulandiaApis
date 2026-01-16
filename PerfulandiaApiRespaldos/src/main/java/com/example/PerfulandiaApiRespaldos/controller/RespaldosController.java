package com.example.PerfulandiaApiRespaldos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import com.example.PerfulandiaApiRespaldos.models.entities.Respaldo;
import com.example.PerfulandiaApiRespaldos.models.request.CrearRespaldo;
import com.example.PerfulandiaApiRespaldos.services.RespaldoService;

@RestController
@RequestMapping("/respaldos")
public class RespaldosController {

    @Autowired
    private RespaldoService service;

    @GetMapping("")
    public List<Respaldo> listarRespaldos() {
        return service.obtenerHistorial();
    }

    @PostMapping("")
    public Respaldo generarBackup(@Valid @RequestBody CrearRespaldo nuevo) {
        return service.crearRespaldo(nuevo);
    }

    @PostMapping("/restaurar/{id}")
    public Respaldo restaurarSistema(@PathVariable int id) {
        return service.restaurarDatos(id);
    }
    
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        return service.eliminarRespaldo(id);
    }
}