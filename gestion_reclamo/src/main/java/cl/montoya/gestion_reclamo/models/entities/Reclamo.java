package cl.montoya.gestion_reclamo.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "reclamo")
public class Reclamo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_reclamo;

    @Column(nullable = false)
    private String descripcion_reclamo;

    @Column(nullable = false)
    private String fecha_reclamo;
    
}
