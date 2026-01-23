package cl.montoya.gestion_reclamo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import cl.montoya.gestion_reclamo.models.entities.Reclamo;
import cl.montoya.gestion_reclamo.models.request.HacerReclamo;

@ExtendWith(MockitoExtension.class)
public class ReclamoTest {

    @Test
    void crearReclamo() {
        HacerReclamo req = new HacerReclamo();
        req.setDescripcion_reclamo("Producto da alergia");
        req.setFecha_reclamo("2026-01-23");

        Reclamo reclamo = new Reclamo();
        reclamo.setDescripcion_reclamo(req.getDescripcion_reclamo());
        reclamo.setFecha_reclamo(req.getFecha_reclamo());

        assertThat(reclamo).isNotNull();
        assertThat(reclamo.getDescripcion_reclamo()).isEqualTo("Producto da alergia");
        assertThat(reclamo.getFecha_reclamo()).isEqualTo("2026-01-23");
    }
}
