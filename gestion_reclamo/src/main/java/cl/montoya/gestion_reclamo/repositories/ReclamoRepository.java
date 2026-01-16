package cl.montoya.gestion_reclamo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.montoya.gestion_reclamo.models.entities.Reclamo;

@Repository
public interface ReclamoRepository extends JpaRepository<Reclamo, Integer> {
    
}
