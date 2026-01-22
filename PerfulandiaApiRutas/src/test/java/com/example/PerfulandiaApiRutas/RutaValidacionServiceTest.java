package com.example.PerfulandiaApiRutas;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.PerfulandiaApiRutas.services.RutaValidacionService;

@ExtendWith(MockitoExtension.class)
public class RutaValidacionServiceTest {

    private final RutaValidacionService servicio = new RutaValidacionService();

    @Test
    void pruebaDistanciaCorrecta() {
        // Caso: 100 km es una distancia válida -> Debe ser TRUE
        boolean resultado = servicio.esDistanciaValida(100);
        assertThat(resultado).isTrue();
    }

    @Test
    void pruebaDistanciaIncorrecta() {
        // Caso: -5 km es imposible -> Debe ser FALSE
        boolean resultado = servicio.esDistanciaValida(-5);
        assertThat(resultado).isFalse();
    }
}