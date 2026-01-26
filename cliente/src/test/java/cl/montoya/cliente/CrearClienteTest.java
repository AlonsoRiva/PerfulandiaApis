package cl.montoya.cliente;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import cl.montoya.cliente.models.entities.Cliente;
import cl.montoya.cliente.models.request.CrearCliente;

@ExtendWith(MockitoExtension.class)
public class CrearClienteTest {

    @Test
    void crearCliente() {
        CrearCliente req = new CrearCliente();

        req.setNombre_cliente("Juan");
        req.setApellido_cliente("Perez");
        req.setDireccion_cliente("Calle Falsa 123");
        req.setTelefono_cliente("+56912345678");
        req.setEmail_cliente("juan.perez@example.com");
        req.setFecha_registro_cliente("2026-01-23");

        Cliente cliente = new Cliente();
        
        cliente.setNombre_cliente(req.getNombre_cliente());
        cliente.setApellido_cliente(req.getApellido_cliente());
        cliente.setDireccion_cliente(req.getDireccion_cliente());
        cliente.setTelefono_cliente(req.getTelefono_cliente());
        cliente.setEmail_cliente(req.getEmail_cliente());
        cliente.setFecha_registro_cliente(req.getFecha_registro_cliente());

        assertThat(cliente).isNotNull();
        assertThat(cliente.getNombre_cliente()).isEqualTo("Juan");
        assertThat(cliente.getApellido_cliente()).isEqualTo("Perez");
        assertThat(cliente.getDireccion_cliente()).isEqualTo("Calle Falsa 123");
        assertThat(cliente.getTelefono_cliente()).isEqualTo("+56912345678");
        assertThat(cliente.getEmail_cliente()).isEqualTo("juan.perez@example.com");
        assertThat(cliente.getFecha_registro_cliente()).isEqualTo("2026-01-23");

    }
}
