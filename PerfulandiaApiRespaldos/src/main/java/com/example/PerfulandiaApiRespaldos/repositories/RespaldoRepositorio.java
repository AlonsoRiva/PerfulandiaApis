package com.example.PerfulandiaApiRespaldos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.PerfulandiaApiRespaldos.models.entities.Respaldo;

@Repository
public interface RespaldoRepositorio extends JpaRepository<Respaldo, Integer> {
    
}