package cl.montoya.registrar_venta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.montoya.registrar_venta.models.entities.Venta;
import cl.montoya.registrar_venta.models.request.AgregarVenta;
import cl.montoya.registrar_venta.models.request.ActualizarVenta;
import cl.montoya.registrar_venta.services.VentaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RequestMapping("venta")
@RestController
public class VentaController {
    
    @Autowired
    private VentaService ventaService;

    @GetMapping("")
    public List<Venta> ObtenerVentas() {
        return ventaService.TodasLasVentas();
    }
    
    @GetMapping("/{id_venta}")
    public Venta ObtenerVentaPorId(@PathVariable int id_venta) {
        return ventaService.ObtenerVentaPorId(id_venta);
    }
    
    @PostMapping("")
    public Venta AgregarVenta(@RequestBody AgregarVenta nueva_venta) {
        return ventaService.AgregarVenta(nueva_venta);
    }
    
    @PutMapping("")
    public Venta ActualizarVenta(@RequestBody ActualizarVenta venta_actualizada) {
        return ventaService.ActualizarVenta(venta_actualizada);
    }
}
