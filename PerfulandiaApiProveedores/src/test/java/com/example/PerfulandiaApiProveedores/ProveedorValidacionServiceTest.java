package com.example.PerfulandiaApiProveedores;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.PerfulandiaApiProveedores.services.ProveedorValidacionService;

@ExtendWith(MockitoExtension.class)
public class ProveedorValidacionServiceTest {

    private final ProveedorValidacionService servicio = new ProveedorValidacionService();

    @Test
    void pruebaTelefonoCorrecto() {
        // Caso: Teléfono de 9 dígitos -> Debe ser TRUE
        boolean resultado = servicio.esTelefonoValido("912345678");
        assertThat(resultado).isTrue();
    }

    @Test
    void pruebaTelefonoCorto() {
        // Caso: Teléfono muy corto (ej: un anexo de 4 dígitos) -> Debe ser FALSE
        boolean resultado = servicio.esTelefonoValido("12311");
        assertThat(resultado).isFalse();
    }
}