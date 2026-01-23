package com.example.PerfulandiaApiReportes.service;

import org.springframework.stereotype.Service;

@Service
public class GeneradorReporteService {

    public String generarContenido(String tipoReporte) {

        if (tipoReporte.equalsIgnoreCase("VENTAS")) {
            return "Reporte de Ventas generado";
        }

        if (tipoReporte.equalsIgnoreCase("INVENTARIO")) {
            return "Reporte de Inventario generado";
        }

        return "Reporte general generado";
    }
}

