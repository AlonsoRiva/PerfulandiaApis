package com.example.PerfulandiaApiRespaldos;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.PerfulandiaApiRespaldos.services.RespaldoValidacionService;

@ExtendWith(MockitoExtension.class)
public class RespaldoValidacionServiceTest {

    private final RespaldoValidacionService servicio = new RespaldoValidacionService();

    @Test
    void pruebaExtensionCorrecta() {
        // Caso: El archivo termina en .sql -> Debe ser TRUE
        boolean resultado = servicio.esArchivoValido("backup_enero.sql");
        assertThat(resultado).isTrue();
    }

    @Test
    void pruebaExtensionIncorrecta() {
        // Caso: El archivo es un .txt -> Debe ser FALSE
        boolean resultado = servicio.esArchivoValido("respaldo.txt");
        assertThat(resultado).isFalse();
    }
}