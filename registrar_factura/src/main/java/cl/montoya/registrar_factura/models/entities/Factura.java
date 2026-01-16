package cl.montoya.registrar_factura.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table  (name = "factura")
public class Factura {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id_factura;

    @Column(nullable = false)
    private int id_usuario;

    @Column(nullable = false)
    private String rut_empresa;
    
    @Column(nullable = false)
    private String razon_social;

    @Column(nullable = false)
    private int id_cliente;

    @Column(nullable = false)
    private String fecha_emision_factura;

    @Column(nullable = false)
    private int total_factura;
    
}
