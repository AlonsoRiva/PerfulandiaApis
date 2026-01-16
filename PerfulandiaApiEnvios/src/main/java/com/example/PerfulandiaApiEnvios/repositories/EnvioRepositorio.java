package com.example.PerfulandiaApiEnvios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.PerfulandiaApiEnvios.models.entities.Envio;

@Repository
public interface EnvioRepositorio extends JpaRepository<Envio, Integer> {
    
}