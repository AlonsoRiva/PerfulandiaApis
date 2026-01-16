package cl.montoya.registrar_factura.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.montoya.registrar_factura.models.entities.Factura;
import cl.montoya.registrar_factura.models.request.ActualizarFactura;
import cl.montoya.registrar_factura.models.request.AgregarFactura;
import cl.montoya.registrar_factura.services.FacturaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RequestMapping("factura")
@RestController
public class FacturaController {
    
    @Autowired
    private FacturaService factura_service;

    @PostMapping("")
    public Factura agregarFactura(@RequestBody AgregarFactura nueva_factura) {
        return factura_service.agregarFactura(nueva_factura);
    }
    
    @GetMapping("")
    public List<Factura> obtenerTodasFacturas() {
        return factura_service.ObtenerTodasFacturas();
    }
    
    @GetMapping("/{id_factura}")
    public Factura BuscarFacturaPorId(@PathVariable int id_factura) {
        return factura_service.BuscarFacturaPorId(id_factura);
    }

    @PutMapping("")
    public Factura ActualizarFactura(@RequestBody ActualizarFactura factura_actualizada) {
        return factura_service.ActualizarFactura(factura_actualizada);
    }

}
