package com.example.PerfulandiaApiEstadoDePedido.services;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import com.example.PerfulandiaApiEstadoDePedido.models.dto.EnvioDto;
import com.example.PerfulandiaApiEstadoDePedido.models.dto.InventarioDto;
import com.example.PerfulandiaApiEstadoDePedido.models.entities.EstadoPedido;
import com.example.PerfulandiaApiEstadoDePedido.models.request.CrearEnvioSolicitud;
import com.example.PerfulandiaApiEstadoDePedido.repositories.EstadoPedidoRepositorio;

@Service
public class EstadoPedidoService {

    @Autowired
    private EstadoPedidoRepositorio repositorio;

    @Autowired
    private WebClient enviosWebClient;

    @Autowired
    private WebClient inventarioWebClient;

    public List<EstadoPedido> obtenerTodos() {
        return repositorio.findAll();
    }

    public EstadoPedido registrarEstado(EstadoPedido nuevo) {
        // 1. CONEXIÓN CON INVENTARIO: Saber qué producto es
        try {
            InventarioDto producto = inventarioWebClient.get()
                .uri("/{id}", nuevo.getIdProducto())
                .retrieve()
                .bodyToMono(InventarioDto.class)
                .block();

            if (producto != null) {
                nuevo.setNombreProducto(producto.nombre());
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado en inventario.");
        }

        // 2. CONEXIÓN CON ENVÍOS: Crear el despacho
        try {
            CrearEnvioSolicitud solicitud = new CrearEnvioSolicitud();
            solicitud.setOrigen("Centro de Distribución");
            solicitud.setDescripcion("Pedido #" + nuevo.getPedidoId() + " - " + nuevo.getNombreProducto());

            EnvioDto envio = enviosWebClient.post()
                .bodyValue(solicitud)
                .retrieve()
                .bodyToMono(EnvioDto.class)
                .block();

            if (envio != null) {
                nuevo.setIdEnvio(envio.id_envio());
            }
        } catch (Exception e) {
            nuevo.setIdEnvio(0); // Fallback
        }

        // Configuración manual de campos
        nuevo.setActualizadoEn(LocalDateTime.now());
        if (nuevo.getEstado() == null) nuevo.setEstado("PROCESANDO");

        return repositorio.save(nuevo);
    }

    public EstadoPedido actualizarEstado(int id, String nuevoEstado) {
        EstadoPedido ep = repositorio.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro no encontrado"));
        
        ep.setEstado(nuevoEstado);
        ep.setActualizadoEn(LocalDateTime.now());
        
        return repositorio.save(ep);
    }
}