package com.example.PerfulandiaApiPedidos.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;


@Entity
@Data
@Table(name = "pedidos")
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pedido;

    @Column(name = "id_sucursal", nullable = false)
    private int idSucursal; // La sucursal que pide los productos

    @Column(columnDefinition = "TEXT", nullable = false)
    private String detalle_productos; // Ej: "10 Perfumes Chanel, 20 Perfumes Dior"

    @Column(nullable = false)
    private String estado; // PENDIENTE, AUTORIZADO, RECHAZADO, ENVIADO

    @Column(name = "fecha_solicitud")
    private LocalDateTime fechaSolicitud;

    @Column(name = "fecha_autorizacion")
    private LocalDateTime fechaAutorizacion;

    @PrePersist
    protected void onCreate() {
        this.fechaSolicitud = LocalDateTime.now();
        if (this.estado == null) {
            this.estado = "PENDIENTE"; // Por defecto nace pendiente de revisión
        }
    }
}