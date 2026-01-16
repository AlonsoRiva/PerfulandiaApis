package com.example.PerfulandiaApiRutas.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.PerfulandiaApiRutas.models.entities.RutaEntrega;
import com.example.PerfulandiaApiRutas.models.request.ActualizarRuta;
import com.example.PerfulandiaApiRutas.models.request.PlanificarRuta;
import com.example.PerfulandiaApiRutas.repositories.RutaRepositorio;

@Service
public class RutaService {

    @Autowired
    private RutaRepositorio repositorio;

    public List<RutaEntrega> listarTodas() {
        return repositorio.findAll();
    }
    
    public RutaEntrega obtenerPorId(int id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ruta no encontrada"));
    }

    public RutaEntrega crear(PlanificarRuta request) {
        RutaEntrega ruta = new RutaEntrega();
        ruta.setZona(request.getZona());
        ruta.setPatenteVehiculo(request.getPatenteVehiculo());
        ruta.setNombreConductor(request.getNombreConductor());
        ruta.setCantidadPedidos(request.getCantidadPedidos());
        ruta.setPrioridad(request.getPrioridad());
        ruta.setFechaSalida(request.getFechaSalida());
        
        ruta.setEstado("PLANIFICADA"); 
        
        return repositorio.save(ruta);
    }

    public RutaEntrega optimizarRuta(int id) {
        RutaEntrega ruta = obtenerPorId(id); 

        if ("OPTIMIZADA".equals(ruta.getEstado())) {
             throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La ruta ya está optimizada");
        }

        ruta.setEstado("OPTIMIZADA");
        ruta.setZona(ruta.getZona() + " (Optimizado)"); 
        
        return repositorio.save(ruta);
    }
    
    public RutaEntrega actualizarRuta(int id, ActualizarRuta request) {
        RutaEntrega existente = obtenerPorId(id);

        existente.setZona(request.getZona());
        existente.setPatenteVehiculo(request.getPatenteVehiculo());
        existente.setNombreConductor(request.getNombreConductor());
        existente.setCantidadPedidos(request.getCantidadPedidos());
        existente.setPrioridad(request.getPrioridad());
        existente.setFechaSalida(request.getFechaSalida());
        
        return repositorio.save(existente);
    }

    public String eliminar(int id) {
        if (!repositorio.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ruta no encontrada");
        }
        repositorio.deleteById(id);
        return "Ruta eliminada del sistema";
    }
}