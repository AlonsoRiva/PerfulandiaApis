package cl.montoya.gestion_reclamo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import cl.montoya.gestion_reclamo.models.entities.Reclamo;
import cl.montoya.gestion_reclamo.models.request.HacerReclamo;
import cl.montoya.gestion_reclamo.repositories.ReclamoRepository;

@Service
public class ReclamoService {
    
    @Autowired
    private ReclamoRepository ReclamoRepository;

    public List<Reclamo> VerTodosLosReclamos() {
        return ReclamoRepository.findAll();
    }

    public Reclamo VerReclamoPorId(int id_reclamo) {
        Reclamo reclamo = ReclamoRepository.findById(id_reclamo).orElse(null);
        if (reclamo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reclamo no encontrado.");
        }
        return reclamo;
    }
    
    public Reclamo HacerReclamo(HacerReclamo nuevo_reclamo) {
        Reclamo reclamo = new Reclamo();
        reclamo.setDescripcion_reclamo(nuevo_reclamo.getDescripcion_reclamo());
        reclamo.setFecha_reclamo(nuevo_reclamo.getFecha_reclamo());
        return ReclamoRepository.save(reclamo);
    }

    public String EliminarReclamo(int id_reclamo) {
        if (ReclamoRepository.existsById(id_reclamo)) {
            ReclamoRepository.deleteById(id_reclamo);
            return "Reclamo eliminado correctamente.";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reclamo no encontrado.");
        }
    }
}
