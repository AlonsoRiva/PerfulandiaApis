package com.example.PerfulandiaApiMonitorizacion.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.PerfulandiaApiMonitorizacion.models.entities.EstadoSistema;
import com.example.PerfulandiaApiMonitorizacion.models.request.ReportarEstado;
import com.example.PerfulandiaApiMonitorizacion.repositories.MonitorizacionRepositorio;

@Service
public class MonitorizacionService {

    @Autowired
    private MonitorizacionRepositorio repositorio;

    public EstadoSistema registrarEstado(ReportarEstado request) {
        EstadoSistema sistema = new EstadoSistema();
        
        sistema.setEstado(request.getEstado());
        sistema.setUsoCpu(request.getUsoCpu());
        sistema.setUsoMemoria(request.getUsoMemoria());
        sistema.setMensaje(request.getMensaje());
        
        return repositorio.save(sistema);
    }

    public List<EstadoSistema> obtenerHistorial() {
        return repositorio.findAll();
    }
    
    public String eliminarEstado(int id) {
        if (!repositorio.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro no encontrado");
        }
        repositorio.deleteById(id);
        return "Registro de estado eliminado correctamente";
    }
}