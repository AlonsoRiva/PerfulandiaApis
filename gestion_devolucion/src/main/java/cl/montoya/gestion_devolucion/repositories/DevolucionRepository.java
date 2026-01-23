package cl.montoya.gestion_devolucion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.montoya.gestion_devolucion.models.entities.Devolucion;

@Repository
public interface DevolucionRepository extends JpaRepository<Devolucion, Integer> {
    
}
