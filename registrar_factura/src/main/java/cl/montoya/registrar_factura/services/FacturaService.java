package cl.montoya.registrar_factura.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import cl.montoya.registrar_factura.models.dto.VentaDto;
import cl.montoya.registrar_factura.models.entities.Factura;
import cl.montoya.registrar_factura.models.request.ActualizarFactura;
import cl.montoya.registrar_factura.models.request.AgregarFactura;
import cl.montoya.registrar_factura.repositories.FacturaRepository;

@Service
public class FacturaService {
    
    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private WebClient ventaWebClient;

    public Factura agregarFactura(AgregarFactura factura_nueva) {
        VentaDto venta = null;
        try {
                venta = ventaWebClient.get()
                .uri("/venta/{id_cliente}", factura_nueva.getId_cliente())
                .retrieve()
                .bodyToMono(VentaDto.class)
                .block();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                "Fallo el web client: " + e.getMessage());
        }
    
        if (venta == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "venta no encontrada.");
        }

        Factura factura_guardar = new Factura();
        factura_guardar.setId_usuario(factura_nueva.getId_usuario());
        factura_guardar.setRut_empresa(factura_nueva.getRut_empresa());
        factura_guardar.setRazon_social(factura_nueva.getRazon_social());
        factura_guardar.setId_cliente(factura_nueva.getId_cliente());
        factura_guardar.setFecha_emision_factura(factura_nueva.getFecha_emision_factura());
        factura_guardar.setTotal_factura(factura_nueva.getTotal_factura());

        return facturaRepository.save(factura_guardar);
    }

    public List<Factura> ObtenerTodasFacturas() {
        return facturaRepository.findAll();
    }

    public Factura BuscarFacturaPorId(int id_factura) {
        Factura factura = facturaRepository.findById(id_factura).orElse(null);
        if (factura == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Factura no encontrada.");
        }
        return factura;
    }

    public Factura ActualizarFactura(ActualizarFactura factura_actualizada) {
        Factura factura = facturaRepository.findById(factura_actualizada.getId_factura()).orElse(null);
        if (factura == null) 
            {throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Factura no encontrada.");
        }else {     
            factura.setId_usuario(factura_actualizada.getId_usuario());
            factura.setRut_empresa(factura_actualizada.getRut_empresa());
            factura.setRazon_social(factura_actualizada.getRazon_social());
            factura.setId_cliente(factura_actualizada.getId_cliente());
            factura.setFecha_emision_factura(factura_actualizada.getFecha_emision_factura());
            factura.setTotal_factura(factura_actualizada.getTotal_factura());
            return facturaRepository.save(factura);
        }
    }
}