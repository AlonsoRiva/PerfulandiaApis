package com.example.PerfulandiaApiMonitorizacion;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.PerfulandiaApiMonitorizacion.services.MetricasValidacionService;

@ExtendWith(MockitoExtension.class)
public class MetricasValidacionServiceTest {

    private final MetricasValidacionService servicio = new MetricasValidacionService();

    @Test
    void pruebaMetricasNormales() {
        // Caso: CPU al 45% y Memoria 2048MB -> Debería ser TRUE
        boolean resultado = servicio.sonMetricasValidas(45, 2048);
        assertThat(resultado).isTrue();
    }

    @Test
    void pruebaCpuImposible() {
        // Caso: CPU al 150% (Imposible) -> Debería ser FALSE
        boolean resultado = servicio.sonMetricasValidas(150, 4096);
        assertThat(resultado).isFalse();
    }

    @Test
    void pruebaMemoriaNegativa() {
        // Caso: Memoria -500 (Error de lectura) -> Debería ser FALSE
        boolean resultado = servicio.sonMetricasValidas(10, -500);
        assertThat(resultado).isFalse();
    }
}