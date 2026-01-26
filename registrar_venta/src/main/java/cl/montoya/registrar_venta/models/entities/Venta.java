package cl.montoya.registrar_venta.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table  (name = "venta")
public class Venta {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id_venta;

    @Column(nullable = false)
    private int id_usuario;

    @Column(nullable = false)
    private int id_producto;

    @Column(nullable = false)
    private String nombre_producto;

    @Column(nullable = false)
    private int cantidad_producto;

    @Column(nullable = false)
    private int id_cliente;
    
    @Column(nullable = false)
    private String nombre_cliente;
    
    @Column(nullable = false)
    private String metodo_pago;

    @Column(nullable = false)
    private String fecha_venta;

    @Column(nullable = false)
    private int monto_total;

    @Column(nullable = false)
    private String estado_venta;
    
}
