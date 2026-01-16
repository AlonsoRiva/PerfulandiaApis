package com.example.PerfulandiaApiEnvios.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import com.example.PerfulandiaApiEnvios.models.dto.SucursalDto;
import com.example.PerfulandiaApiEnvios.models.entities.Envio;
import com.example.PerfulandiaApiEnvios.models.request.CrearEnvio;
import com.example.PerfulandiaApiEnvios.repositories.EnvioRepositorio;

@Service
public class EnvioService {

    @Autowired
    private EnvioRepositorio repositorio;

    @Autowired
    private WebClient sucursalWebClient;

    public List<Envio> listarTodos() {
        return repositorio.findAll();
    }

    public Envio crearEnvio(CrearEnvio request) {
        // Validación con el microservicio de Sucursales
        if (request.getIdSucursalDestino() != null) {
            try {
                sucursalWebClient.get()
                    .uri("/{id}", request.getIdSucursalDestino())
                    .retrieve()
                    .bodyToMono(SucursalDto.class)
                    .block(); 
            } catch (Exception e) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La sucursal destino no existe en el sistema.");
            }
        }
        
        Envio envio = new Envio();
        envio.setOrigen(request.getOrigen());
        envio.setIdSucursalDestino(request.getIdSucursalDestino());
        envio.setDireccionCliente(request.getDireccionCliente());
        envio.setDescripcion(request.getDescripcion());
        envio.setEstado("DESPACHADO");
        
        return repositorio.save(envio);
    }

    public Envio actualizarEstado(int id, String nuevoEstado) {
        Envio envio = repositorio.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Envío no encontrado"));
        
        envio.setEstado(nuevoEstado);
        return repositorio.save(envio);
    }
}