package com.example.PerfulandiaApiMonitorizacion.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import com.example.PerfulandiaApiMonitorizacion.models.entities.EstadoSistema;
import com.example.PerfulandiaApiMonitorizacion.models.request.ReportarEstado;
import com.example.PerfulandiaApiMonitorizacion.services.MonitorizacionService;

@Repository
@RestController
@RequestMapping("/estado_sistema")
public class MonitorizacionController {

    @Autowired
    private MonitorizacionService service;

    @GetMapping("")
    public List<EstadoSistema> verEstadoSistema() {
        return service.obtenerHistorial();
    }

    @PostMapping("")
    public EstadoSistema reportarEstado(@Valid @RequestBody ReportarEstado reporte) {
        return service.registrarEstado(reporte);
    }

    // NUEVO ENDPOINT AGREGADO
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        return service.eliminarEstado(id);
    }
}
