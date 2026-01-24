package cl.montoya.registrar_venta;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import cl.montoya.registrar_venta.models.request.AgregarVenta;
import cl.montoya.registrar_venta.repositories.VentaRepository;
import cl.montoya.registrar_venta.services.VentaService;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RegistrarVentaTest {

    @Mock
    private VentaRepository ventaRepository;

    @InjectMocks
    private VentaService ventaService;

    @Test
    void agregarVentaTest() {

        AgregarVenta nuevaVenta = new AgregarVenta();
        
        ventaService.AgregarVenta(nuevaVenta);
        
        verify(ventaRepository, times(1)).save(any());
    }
}
