package com.example.PerfulandiaApiSucursales.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.PerfulandiaApiSucursales.models.entities.Sucursal;
import com.example.PerfulandiaApiSucursales.models.request.ActualizarSucursal;
import com.example.PerfulandiaApiSucursales.models.request.AgregarSucursal;
import com.example.PerfulandiaApiSucursales.repositories.SucursalRepositorio;

@Service
public class SucursalService {

    @Autowired
    private SucursalRepositorio sucursalRepositorio;

    public List<Sucursal> listarTodo() {
        return sucursalRepositorio.findAll();
    }

    public Sucursal obtenerPorId(int id) {
        return sucursalRepositorio.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sucursal no encontrada"));
    }

    public Sucursal agregar(AgregarSucursal request) {
        Sucursal nueva = new Sucursal();
        nueva.setNombre(request.getNombre());
        nueva.setDireccion(request.getDireccion());
        nueva.setHorarioApertura(request.getHorarioApertura());
        nueva.setPersonalAsignado(request.getPersonalAsignado());
        nueva.setPoliticasLocales(request.getPoliticasLocales());
        
        return sucursalRepositorio.save(nueva);
    }

    public Sucursal actualizar(ActualizarSucursal request) {
        Sucursal existente = obtenerPorId(request.getId_sucursal());

        // Actualizamos solo si los campos vienen en la petición (no nulos o lógica que prefieras)
        // Para simplificar, aquí sobreescribimos todo lo que venga distinto de null
        if(request.getNombre() != null) existente.setNombre(request.getNombre());
        if(request.getDireccion() != null) existente.setDireccion(request.getDireccion());
        if(request.getHorarioApertura() != null) existente.setHorarioApertura(request.getHorarioApertura());
        if(request.getPersonalAsignado() != null) existente.setPersonalAsignado(request.getPersonalAsignado());
        if(request.getPoliticasLocales() != null) existente.setPoliticasLocales(request.getPoliticasLocales());

        return sucursalRepositorio.save(existente);
    }

    public String eliminar(int id) {
        if (!sucursalRepositorio.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sucursal no encontrada");
        }
        sucursalRepositorio.deleteById(id);
        return "Sucursal eliminada correctamente.";
    }
}