package com.example.PerfulandiaApiRespaldos.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.PerfulandiaApiRespaldos.models.entities.Respaldo;
import com.example.PerfulandiaApiRespaldos.models.request.CrearRespaldo;
import com.example.PerfulandiaApiRespaldos.repositories.RespaldoRepositorio;

@Service
public class RespaldoService {

    @Autowired
    private RespaldoRepositorio repositorio;

    public List<Respaldo> obtenerHistorial() {
        return repositorio.findAll();
    }


    public Respaldo crearRespaldo(CrearRespaldo request) {
        Respaldo respaldo = new Respaldo();
        respaldo.setNombreArchivo(request.getNombreArchivo());
        respaldo.setFecha(request.getFecha());
        respaldo.setTipo(request.getTipo());
        respaldo.setEstado("EXITOSO"); 
        
        return repositorio.save(respaldo);
    }

    public Respaldo restaurarDatos(int id) {
        Respaldo respaldo = repositorio.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Respaldo no encontrado"));

     
        respaldo.setEstado("RESTAURADO_HOY");
        
        return repositorio.save(respaldo);
    }
    
    public String eliminarRespaldo(int id) {
        if (!repositorio.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Respaldo no encontrado");
        }
        repositorio.deleteById(id);
        return "Archivo de respaldo eliminado del registro";
    }
}