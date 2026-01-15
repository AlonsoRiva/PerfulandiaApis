package com.example.PerfulandiaApiInventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.PerfulandiaApiInventario.models.entities.Inventario;

@Repository
public interface InventarioRepositorio extends JpaRepository<Inventario, Integer>{

    

    

    
}
