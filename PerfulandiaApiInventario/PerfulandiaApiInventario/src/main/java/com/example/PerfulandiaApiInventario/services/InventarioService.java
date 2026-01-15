package com.example.PerfulandiaApiInventario.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.PerfulandiaApiInventario.models.entities.Inventario;
import com.example.PerfulandiaApiInventario.models.request.AgregarInventario;
import com.example.PerfulandiaApiInventario.repositories.InventarioRepositorio;

@Service
public class InventarioService {

    @Autowired
    private InventarioRepositorio inventarioRepositorio;

    public List<Inventario> listarTodo() {
        return inventarioRepositorio.findAll();
    }

    public Inventario obtenerPorId(int id) {
        return inventarioRepositorio.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado en inventario"));
    }

    public Inventario agregar(AgregarInventario request) {
        Inventario nuevo = new Inventario();
        nuevo.setNombre(request.getNombre());
        nuevo.setGenero(request.getGenero());
        nuevo.setPrecio(request.getPrecio());
        nuevo.setStock(request.getStock());
        return inventarioRepositorio.save(nuevo);
    }
    
    // Método para editar datos básicos (nombre, precio, etc)
    public Inventario actualizar(int id, AgregarInventario request) {
        Inventario existente = obtenerPorId(id);
        existente.setNombre(request.getNombre());
        existente.setGenero(request.getGenero());
        existente.setPrecio(request.getPrecio());
        existente.setStock(request.getStock());
        return inventarioRepositorio.save(existente);
    }

    
    public String eliminar(int id) {
        if (!inventarioRepositorio.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado");
        }
        inventarioRepositorio.deleteById(id);
        return "Producto eliminado del inventario correctamente";
    }
}
