package com.example.PerfulandiaApiReportes.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import com.example.PerfulandiaApiReportes.models.entities.Reporte;
import com.example.PerfulandiaApiReportes.models.request.GenerarReportes;
import com.example.PerfulandiaApiReportes.service.ReporteService;

@RestController
@RequestMapping("/pfl_reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    // 1. Ver historial de todos los reportes
    @GetMapping("")
    public List<Reporte> obtenerTodos() {
        return reporteService.listarTodos();
    }

    // 2. Ver un reporte específico
    @GetMapping("/{id}")
    public Reporte obtenerPorId(@PathVariable int id) {
        return reporteService.obtenerPorId(id);
    }

    // 3. Ver reportes de una sucursal específica
    @GetMapping("/sucursal/{idSucursal}")
    public List<Reporte> obtenerPorSucursal(@PathVariable int idSucursal) {
        return reporteService.listarPorSucursal(idSucursal);
    }

    // 4. GENERAR un nuevo reporte (Equivalente al POST crear)
    @PostMapping("/generar")
    public Reporte generar(@Valid @RequestBody GenerarReportes request) {
        return reporteService.generarReporte(request);
    }

    // 5. Eliminar un reporte del historial
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        return reporteService.eliminar(id);
    }
}