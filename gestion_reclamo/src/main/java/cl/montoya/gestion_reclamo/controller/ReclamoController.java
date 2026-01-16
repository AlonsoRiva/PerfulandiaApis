package cl.montoya.gestion_reclamo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.montoya.gestion_reclamo.models.entities.Reclamo;
import cl.montoya.gestion_reclamo.models.request.HacerReclamo;
import cl.montoya.gestion_reclamo.services.ReclamoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RequestMapping("reclamo")
@RestController
public class ReclamoController {

    @Autowired
    private ReclamoService ReclamoService;

    @GetMapping("")
    public List<Reclamo> VerTodosLosReclamos() {
        return ReclamoService.VerTodosLosReclamos();
    }

    @GetMapping("/{id_reclamo}")
    public Reclamo VerReclamoPorId(@PathVariable int id_reclamo) {
        return ReclamoService.VerReclamoPorId(id_reclamo);
    }
    
    @PostMapping("")
    public Reclamo HacerReclamo(@RequestBody HacerReclamo nuevo_reclamo) {
        return ReclamoService.HacerReclamo(nuevo_reclamo);
    }
    

    @DeleteMapping("/{id_reclamo}")
    public String EliminarReclamo(@PathVariable int id_reclamo) {
        return ReclamoService.EliminarReclamo(id_reclamo);
    }    
}
