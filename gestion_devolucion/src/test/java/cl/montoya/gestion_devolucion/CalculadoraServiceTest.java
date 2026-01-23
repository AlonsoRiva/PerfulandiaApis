package cl.montoya.gestion_devolucion;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import cl.montoya.gestion_devolucion.services.CalculadoraService;


@ExtendWith(MockitoExtension.class)
public class CalculadoraServiceTest {
    
    private final CalculadoraService servicio = new CalculadoraService();

    @Test
    void pruebaSumar() {
        int resultado = servicio.sumar(20, 50);
        assertThat(resultado).isEqualTo(70);
    }

}
