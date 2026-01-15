package com.example.PerfulandiaApiMonitorizacion.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "estado_sistema")
public class EstadoSistema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_estado;

    @Column(nullable = false)
    private String estado; 

    @Column(name = "uso_cpu")
    private Integer usoCpu; 

    @Column(name = "uso_memoria")
    private Integer usoMemoria; 

    @Column(nullable = true)
    private String mensaje; 

}