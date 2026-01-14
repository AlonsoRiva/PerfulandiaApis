package com.example.PerfulandiaApiPermisos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.PerfulandiaApiPermisos.models.entities.Permiso;
import com.example.PerfulandiaApiPermisos.models.request.ActualizarPermiso;
import com.example.PerfulandiaApiPermisos.models.request.AgregarPermiso;
import com.example.PerfulandiaApiPermisos.services.PermisosService;

@RestController
@RequestMapping("/pfl_permisos")
public class PermisosController {

    @Autowired
    private PermisosService permisosService;

    @GetMapping("")
    public List<Permiso> obtenerTodos() {
        return permisosService.listarPermisos();
    }

    @GetMapping("/{id}")
    public Permiso obtenerPorId(@PathVariable int id) {
        return permisosService.obtenerPermisoPorId(id);
    }

    @PostMapping("")
    public Permiso crear(@RequestBody AgregarPermiso nuevo) {
        return permisosService.crearPermiso(nuevo);
    }

    @PutMapping("")
    public Permiso actualizar(@RequestBody ActualizarPermiso actualizacion) {
        return permisosService.actualizarPermiso(actualizacion);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        return permisosService.eliminarPermiso(id);
    }
}