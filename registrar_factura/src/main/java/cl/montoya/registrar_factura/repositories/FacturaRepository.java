package cl.montoya.registrar_factura.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.montoya.registrar_factura.models.entities.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer> {
    
}
