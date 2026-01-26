package cl.montoya.cliente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.montoya.cliente.models.entities.Cliente;
import cl.montoya.cliente.models.request.ActualizarCliente;
import cl.montoya.cliente.models.request.CrearCliente;
import cl.montoya.cliente.services.ClienteService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RequestMapping("cliente")
@RestController
public class ClienteController {
    
    @Autowired
    private ClienteService cliente_service;

    @PostMapping("")
    public Cliente CrearCliente(@RequestBody CrearCliente nuevo_cliente) {
        return cliente_service.CrearCliente(nuevo_cliente);
        
    }
    
    @GetMapping("")
    public List<Cliente> ObtenerTodosClientes() {
        return cliente_service.ObtenerTodosClientes();
    }

    @GetMapping("/{id_cliente}")
    public Cliente ClientePorId(@PathVariable int id_cliente) {
        return cliente_service.ClientePorId(id_cliente);
    }
    

    @PutMapping("")
    public Cliente ActualizarCliente(@RequestBody ActualizarCliente cliente_actualizado) {
        return cliente_service.ActualizarCliente(cliente_actualizado);
    }

    @DeleteMapping("/{id_cliente}")
    public String EliminarCliente(@PathVariable int id_cliente) {
        return cliente_service.EliminarCliente(id_cliente);
    }
    
}
