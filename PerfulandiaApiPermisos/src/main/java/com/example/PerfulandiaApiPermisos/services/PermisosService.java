package com.example.PerfulandiaApiPermisos.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.PerfulandiaApiPermisos.models.entities.Permiso;
import com.example.PerfulandiaApiPermisos.models.request.ActualizarPermiso;
import com.example.PerfulandiaApiPermisos.models.request.AgregarPermiso;
import com.example.PerfulandiaApiPermisos.repositories.PermisoRepositorio;

@Service
public class PermisosService {

    @Autowired
    private PermisoRepositorio permisoRepositorio;

    // Obtener todos
    public List<Permiso> listarPermisos() {
        return permisoRepositorio.findAll();
    }

    // Obtener por ID
    public Permiso obtenerPermisoPorId(int id) {
        return permisoRepositorio.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Permiso no encontrado."));
    }

    // Crear
    public Permiso crearPermiso(AgregarPermiso request) {
        Permiso permiso = new Permiso();
        permiso.setNombre(request.getNombre());
        permiso.setModulo(request.getModulo());
        permiso.setDescripcion(request.getDescripcion());
        return permisoRepositorio.save(permiso);
    }

    // Actualizar
    public Permiso actualizarPermiso(ActualizarPermiso request) {
        Permiso permiso = permisoRepositorio.findById(request.getId_permiso())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Permiso no encontrado."));

        permiso.setNombre(request.getNombre());
        permiso.setModulo(request.getModulo());
        permiso.setDescripcion(request.getDescripcion());
        
        return permisoRepositorio.save(permiso);
    }

    // Eliminar
    public String eliminarPermiso(int id) {
        if (permisoRepositorio.existsById(id)) {
            permisoRepositorio.deleteById(id);
            return "Permiso eliminado correctamente.";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Permiso no encontrado.");
        }
    }
}