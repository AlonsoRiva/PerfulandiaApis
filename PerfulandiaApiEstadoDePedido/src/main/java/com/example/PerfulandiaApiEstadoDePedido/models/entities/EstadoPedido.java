package com.example.PerfulandiaApiEstadoDePedido.models.entities;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "estado_pedidos")
public class EstadoPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Cambiado de id_envio a id para evitar conflictos

    @Column(name = "id_pedido", nullable = false)
    private int pedidoId;

    @Column(name = "id_producto", nullable = false)
    private int idProducto;

    @Column(name = "nombre_producto")
    private String nombreProducto; 

    @Column(name = "id_envio_relacionado", nullable = false) 
    private int idEnvio;

    @Column(nullable = false)
    private String estado;

    @Column(name = "actualizado_en", nullable = false)
    private LocalDateTime actualizadoEn;
}