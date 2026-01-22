package com.example.PerfulandiaApiEnvios;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.PerfulandiaApiEnvios.services.EnvioStateService;

@ExtendWith(MockitoExtension.class)
public class EnvioStateServiceTest {

    private final EnvioStateService servicio = new EnvioStateService();

    @Test
    void pruebaCambioNormal_Valido() {
        // Caso: De PENDIENTE a EN RUTA -> Es el flujo normal, debe ser TRUE
        boolean resultado = servicio.esCambioEstadoValido("PENDIENTE", "EN RUTA");
        assertThat(resultado).isTrue();
    }

    @Test
    void pruebaRetrocederEntregado_Invalido() {
        // Caso Crítico: Intentar cambiar un pedido ENTREGADO a EN RUTA.
        // Esto es ilógico (y peligroso), el sistema debe impedirlo -> FALSE
        boolean resultado = servicio.esCambioEstadoValido("ENTREGADO", "EN RUTA");
        assertThat(resultado).isFalse();
    }
}