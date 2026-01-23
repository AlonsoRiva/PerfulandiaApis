package com.example.PerfulandiaApiReportes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.PerfulandiaApiReportes.service.ReporteService;

public class ReporteServiceTest {

    private final ReporteService reporteService = new ReporteService();

    @Test
    void probandoReporteVentas() {

        String resultado = reporteService.generarContenido("VENTAS");

        assertEquals("Reporte de Ventas generado", resultado);
    }
}
