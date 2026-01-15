package com.example.PerfulandiaApiProveedores.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.PerfulandiaApiProveedores.models.entities.Proveedor;
import com.example.PerfulandiaApiProveedores.models.request.ActualizarProveedor;
import com.example.PerfulandiaApiProveedores.models.request.AgregarProveedor;
import com.example.PerfulandiaApiProveedores.repositories.ProveedorRepositorio;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepositorio proveedorRepositorio;

    public List<Proveedor> listarTodos() {
        return proveedorRepositorio.findAll();
    }

    public Proveedor obtenerPorId(int id) {
        return proveedorRepositorio.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Proveedor no encontrado"));
    }

    public Proveedor crear(AgregarProveedor request) {
        
        Proveedor p = new Proveedor();
        p.setNombreEmpresa(request.getNombreEmpresa());
        p.setContactoNombre(request.getContactoNombre());
        p.setTelefono(request.getTelefono());
        p.setEmail(request.getEmail());
        
        return proveedorRepositorio.save(p);
    }

    public Proveedor actualizar(ActualizarProveedor request) {
        Proveedor p = obtenerPorId(request.getId_proveedor());

        p.setNombreEmpresa(request.getNombreEmpresa());
        p.setContactoNombre(request.getContactoNombre());
        p.setTelefono(request.getTelefono());
        p.setEmail(request.getEmail());

        return proveedorRepositorio.save(p);
    }

    public String eliminar(int id) {
        if (!proveedorRepositorio.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Proveedor no encontrado");
        }
        proveedorRepositorio.deleteById(id);
        return "Proveedor eliminado correctamente";
    }
}