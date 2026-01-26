package cl.montoya.cliente.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cliente;

    @Column(nullable = false)
    private String nombre_cliente;

    @Column(nullable = false)
    private String apellido_cliente;

    @Column(nullable = false)
    private String direccion_cliente;

    @Column(nullable = false)
    private String telefono_cliente;

    @Column(nullable = false)
    private String email_cliente;

    @Column(nullable = false)
    private String fecha_registro_cliente;
}