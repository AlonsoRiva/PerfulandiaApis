package com.example.PerfulandiaApiReportes.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.PerfulandiaApiReportes.models.entities.Reporte;
import com.example.PerfulandiaApiReportes.models.request.GenerarReportes;
import com.example.PerfulandiaApiReportes.repositories.ReporteRepositorio;

@Service
public class ReporteService {

    @Autowired
    private ReporteRepositorio reporteRepositorio;

    public List<Reporte> listarTodos() {
        return reporteRepositorio.findAll();
    }
    
    public List<Reporte> listarPorSucursal(int idSucursal) {
        return reporteRepositorio.findByIdSucursal(idSucursal);
    }

    public Reporte obtenerPorId(int id) {
        return reporteRepositorio.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reporte no encontrado"));
    }

    public Reporte generarReporte(GenerarReportes request) {
        Reporte nuevoReporte = new Reporte();
        nuevoReporte.setTipoReporte(request.getTipoReporte());
        nuevoReporte.setIdSucursal(request.getIdSucursal());

        // LÓGICA DE NEGOCIO SIMULADA
        // Aquí es donde en el futuro conectarías con los otros microservicios
        // para calcular los datos reales.
        String contenidoGenerado = "";

        switch (request.getTipoReporte().toUpperCase()) {
            case "VENTAS":
                contenidoGenerado = "Reporte de Ventas " + request.getPeriodo() + ": Total vendido $15.000.000. Transacciones: 150.";
                break;
            case "INVENTARIO":
                contenidoGenerado = "Reporte de Stock: 500 unidades disponibles. 20 productos bajo stock mínimo.";
                break;
            case "RENDIMIENTO":
                contenidoGenerado = "KPI Sucursal: 98% de cumplimiento en horarios. Satisfacción al cliente: 4.5/5.";
                break;
            default:
                contenidoGenerado = "Reporte general generado sin datos específicos.";
        }

        nuevoReporte.setContenido(contenidoGenerado);
        
        return reporteRepositorio.save(nuevoReporte);
    }

    public String eliminar(int id) {
        if (!reporteRepositorio.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reporte no encontrado");
        }
        reporteRepositorio.deleteById(id);
        return "Reporte eliminado del historial.";
    }
}