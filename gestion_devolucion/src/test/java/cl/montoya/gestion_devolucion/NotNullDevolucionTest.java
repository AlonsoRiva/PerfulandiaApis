package cl.montoya.gestion_devolucion;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import cl.montoya.gestion_devolucion.models.entities.Devolucion;

@ExtendWith(MockitoExtension.class)
public class NotNullDevolucionTest {

    @Test
    void NotNullDevolucion() {
        Devolucion devolucion = new Devolucion();
        
        assertNotNull(devolucion);
    }
}
