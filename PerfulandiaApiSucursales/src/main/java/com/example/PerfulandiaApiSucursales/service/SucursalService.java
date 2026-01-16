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
    private SucursalRepositorio repositorio;

    public List<Sucursal> listarTodas() {
        return repositorio.findAll();
    }

    public Sucursal obtenerPorId(int id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sucursal no encontrada"));
    }

    public Sucursal crear(AgregarSucursal request) {
        
        Sucursal s = new Sucursal();
        s.setNombre(request.getNombre());
        s.setDireccion(request.getDireccion());
        s.setHorarioAtencion(request.getHorarioAtencion());
        s.setPersonalAsignado(request.getPersonalAsignado());
        s.setPoliticas(request.getPoliticas());
        
        return repositorio.save(s);
    }

    public Sucursal actualizar(ActualizarSucursal request) {
        Sucursal s = obtenerPorId(request.getId_sucursal());

        s.setNombre(request.getNombre());
        s.setDireccion(request.getDireccion());
        s.setHorarioAtencion(request.getHorarioAtencion());
        s.setPersonalAsignado(request.getPersonalAsignado());
        s.setPoliticas(request.getPoliticas());

        return repositorio.save(s);
    }

    public String eliminar(int id) {
        if (!repositorio.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sucursal no encontrada");
        }
        repositorio.deleteById(id);
        return "Sucursal eliminada correctamente";
    }
}