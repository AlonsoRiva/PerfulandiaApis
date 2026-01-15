package com.example.PerfulandiaApiMonitorizacion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.PerfulandiaApiMonitorizacion.models.entities.EstadoSistema;

@Repository
public interface MonitorizacionRepositorio extends JpaRepository<EstadoSistema, Integer> {
    
}