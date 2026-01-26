package cl.montoya.gestion_devolucion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import cl.montoya.gestion_devolucion.models.dto.ClienteDto;
import cl.montoya.gestion_devolucion.models.dto.VentaDto;
import cl.montoya.gestion_devolucion.models.entities.Devolucion;
import cl.montoya.gestion_devolucion.models.request.ActualizarDevolucion;
import cl.montoya.gestion_devolucion.models.request.HacerDevolucion;
import cl.montoya.gestion_devolucion.repositories.DevolucionRepository;

@Service
public class DevolucionService {
    
    @Autowired
    private DevolucionRepository DevolucionRepository;

    @Autowired
    @Qualifier("VentaWebClient")
    private WebClient VentaWebClient;

    @Autowired
    @Qualifier("ClienteWebClient")
    private WebClient ClienteWebClient;

    public Devolucion HacerDevolucion(HacerDevolucion devolucion_nueva) {
        try {
                VentaDto venta = VentaWebClient.get()
                .uri("/venta/{id_cliente}", devolucion_nueva.getId_cliente())
                .retrieve()
                .bodyToMono(VentaDto.class)
                .block();
                
            if (venta != null) {
                devolucion_nueva.setId_venta(venta.id_venta());
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                "Fallo el web client: " + e.getMessage());
        }
    
        
        try {
                ClienteDto cliente = ClienteWebClient.get()
                .uri("/cliente/{id_cliente}", devolucion_nueva.getId_cliente())
                .retrieve()
                .bodyToMono(ClienteDto.class)
                .block();
                
            if (cliente != null) {
                devolucion_nueva.setId_cliente(cliente.id_cliente());
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                "Fallo el web client: " + e.getMessage());
        }

        Devolucion devolucion_guardar = new Devolucion();
        devolucion_guardar.setId_usuario(devolucion_nueva.getId_usuario());
        devolucion_guardar.setId_cliente(devolucion_nueva.getId_cliente());
        devolucion_guardar.setId_venta(devolucion_nueva.getId_venta());
        devolucion_guardar.setMotivo_devolucion(devolucion_nueva.getMotivo_devolucion());
        devolucion_guardar.setFecha_devolucion(devolucion_nueva.getFecha_devolucion());
        devolucion_guardar.setMonto_reembolsado(devolucion_nueva.getMonto_reembolsado());
        devolucion_guardar.setEstado_venta(devolucion_nueva.getEstado_venta());
        
        return DevolucionRepository.save(devolucion_guardar);
    }

        public List<Devolucion> ObtenerTodasDevoluciones() {
            return DevolucionRepository.findAll();
    }

        public Devolucion BuscarDevolucionPorId(int id_devolucion) {
        return DevolucionRepository.findById(id_devolucion).orElse(null);
    }

        public Devolucion ActualizarDevolucion(ActualizarDevolucion devolucion_actualizada) {
            Devolucion devolucion_existente = BuscarDevolucionPorId(devolucion_actualizada.getId_devolucion());
            if (devolucion_existente == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Devolucion no encontrada.");
            }else {
                devolucion_existente.setId_usuario(devolucion_actualizada.getId_usuario());
                devolucion_existente.setId_cliente(devolucion_actualizada.getId_cliente());
                devolucion_existente.setId_venta(devolucion_actualizada.getId_venta());
                devolucion_existente.setMotivo_devolucion(devolucion_actualizada.getMotivo_devolucion());
                devolucion_existente.setFecha_devolucion(devolucion_actualizada.getFecha_devolucion());
                devolucion_existente.setMonto_reembolsado(devolucion_actualizada.getMonto_reembolsado());
                devolucion_existente.setEstado_venta(devolucion_actualizada.getEstado_venta());
                return DevolucionRepository.save(devolucion_existente);
            }
        }
}
