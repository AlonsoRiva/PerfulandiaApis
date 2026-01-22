package com.example.PerfulandiaApiPermisos;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.PerfulandiaApiPermisos.services.PermisoValidacionService;

@ExtendWith(MockitoExtension.class)
public class PermisoValidacionServiceTest {

    private final PermisoValidacionService servicio = new PermisoValidacionService();

    @Test
    void pruebaPermisoCorrecto() {
        // Caso: Enviamos "VENTAS" (todo mayúsculas) -> Debe ser TRUE
        assertThat(servicio.esNombreValido("VENTAS")).isTrue();
    }

    @Test
    void pruebaPermisoIncorrecto() {
        // Caso: Enviamos "ventas" (minúsculas) -> Debe ser FALSE
        assertThat(servicio.esNombreValido("ventas")).isFalse();
    }
}