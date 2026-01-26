package cl.montoya.gestion_devolucion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.montoya.gestion_devolucion.models.entities.Devolucion;
import cl.montoya.gestion_devolucion.models.request.ActualizarDevolucion;
import cl.montoya.gestion_devolucion.models.request.HacerDevolucion;
import cl.montoya.gestion_devolucion.services.DevolucionService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RequestMapping("/devolucion")
@RestController
public class DevolucionController {
    
    @Autowired
    private DevolucionService devolucionService;

    @PostMapping("")
    public Devolucion HacerDevolucion(@RequestBody HacerDevolucion nueva_devolucion) {
        return devolucionService.HacerDevolucion(nueva_devolucion);
        
    }
    
    @GetMapping("")
    public List<Devolucion> ObtenerTodasDevoluciones() {
        return devolucionService.ObtenerTodasDevoluciones();
    }

    @GetMapping("/{id_devolucion}")
    public Devolucion BuscarDevolucionPorId(@PathVariable int id_devolucion) {
        return devolucionService.BuscarDevolucionPorId(id_devolucion);
    }
    

    @PutMapping("")
    public Devolucion ActualizarDevolucion(@RequestBody ActualizarDevolucion devolucion_actualizada) {
        return devolucionService.ActualizarDevolucion(devolucion_actualizada);
    }
    
}
