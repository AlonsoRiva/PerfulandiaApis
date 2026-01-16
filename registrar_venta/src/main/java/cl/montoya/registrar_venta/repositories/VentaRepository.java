package cl.montoya.registrar_venta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.montoya.registrar_venta.models.entities.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {
    
}
