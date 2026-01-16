package com.example.PerfulandiaApiRutas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.PerfulandiaApiRutas.models.entities.RutaEntrega;

@Repository
public interface RutaRepositorio extends JpaRepository<RutaEntrega, Integer> {
    
}