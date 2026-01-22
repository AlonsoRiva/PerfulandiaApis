package com.example.PerfulandiaApiUsuarios;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.PerfulandiaApiUsuarios.services.ValidacionService;

@ExtendWith(MockitoExtension.class)
public class ValidacionServiceTest {

    // Instanciamos el servicio que acabamos de crear
    private final ValidacionService servicio = new ValidacionService();

    @Test
    void pruebaClaveEsSegura(){
        // Caso: Enviamos una clave de más de 8 caracteres
        boolean resultado = servicio.esClaveSegura("Perfulandia2026");
        
        // Esperamos que sea VERDADERO (true)
        assertThat(resultado).isTrue();
    }

    @Test
    void pruebaClaveEsInsegura(){
        // Caso: Enviamos una clave corta
        boolean resultado = servicio.esClaveSegura("123");
        
        // Esperamos que sea FALSO (false)
        assertThat(resultado).isFalse();
    }
}