package cl.montoya.gestion_devolucion.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "devolucion")
public class Devolucion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_devolucion;

    @Column(nullable = false)
    private int id_usuario;

    @Column(nullable = false)
    private int id_cliente;

    @Column(nullable = false)
    private int id_venta;

    @Column(nullable = false)
    private String motivo_devolucion;

    @Column(nullable = false)
    private String fecha_devolucion;

    @Column(nullable = false)
    private int monto_reembolsado;

    @Column(nullable = false)
    private String estado_venta;

    
}
