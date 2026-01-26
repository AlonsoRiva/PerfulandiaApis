package cl.montoya.cliente.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import cl.montoya.cliente.models.entities.Cliente;
import cl.montoya.cliente.models.request.ActualizarCliente;
import cl.montoya.cliente.models.request.CrearCliente;
import cl.montoya.cliente.repositories.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> ObtenerTodosClientes() {
        return clienteRepository.findAll();
    }

    public Cliente ClientePorId(int id_cliente) {
        return clienteRepository.findById(id_cliente).orElse(null);
    }

    public Cliente CrearCliente(CrearCliente nuevo_cliente) {
        Cliente cliente = new Cliente();
        cliente.setNombre_cliente(nuevo_cliente.getNombre_cliente());
        cliente.setApellido_cliente(nuevo_cliente.getApellido_cliente());
        cliente.setDireccion_cliente(nuevo_cliente.getDireccion_cliente());
        cliente.setTelefono_cliente(nuevo_cliente.getTelefono_cliente());
        cliente.setEmail_cliente(nuevo_cliente.getEmail_cliente());
        cliente.setFecha_registro_cliente(nuevo_cliente.getFecha_registro_cliente());
        return clienteRepository.save(cliente);
    }

    public Cliente ActualizarCliente(ActualizarCliente cliente_actualizado) {
        Cliente cliente_exsite = ClientePorId(cliente_actualizado.getId_cliente());
        if (cliente_exsite == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado.");
        } else {
            cliente_exsite.setId_cliente(cliente_actualizado.getId_cliente());
            cliente_exsite.setNombre_cliente(cliente_actualizado.getNombre_cliente());
            cliente_exsite.setApellido_cliente(cliente_actualizado.getApellido_cliente());
            cliente_exsite.setDireccion_cliente(cliente_actualizado.getDireccion_cliente());
            cliente_exsite.setTelefono_cliente(cliente_actualizado.getTelefono_cliente());
            cliente_exsite.setEmail_cliente(cliente_actualizado.getEmail_cliente());
            return clienteRepository.save(cliente_exsite);
        }
    }

    public String EliminarCliente(int id_cliente) {
        if (clienteRepository.existsById(id_cliente)) {
            clienteRepository.deleteById(id_cliente);
            return "Cliente eliminado correctamente.";
        } else {
            return "Cliente no encontrado.";
        }
    }
    
}
