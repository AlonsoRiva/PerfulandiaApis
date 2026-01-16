package com.example.PerfulandiaApiReportes.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "reportes")
public class Reporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_reporte;

    @Column(name = "tipo_reporte", nullable = false)
    private String tipoReporte; // "VENTAS", "INVENTARIO", "RENDIMIENTO"

    @Column(name = "id_sucursal")
    private Integer idSucursal; // Opcional: Para saber de qué sucursal es el reporte

    @Column(columnDefinition = "TEXT")
    private String contenido; // Aquí guardamos el resultado del reporte (ej. JSON o texto)

    @Column(name = "fecha_generacion")
    private LocalDateTime fechaGeneracion;

    @PrePersist
    protected void onCreate() {
        this.fechaGeneracion = LocalDateTime.now();
    }
}