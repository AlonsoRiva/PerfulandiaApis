package com.example.PerfulandiaApiProveedores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.PerfulandiaApiProveedores.models.entities.Proveedor;

@Repository
public interface ProveedorRepositorio extends JpaRepository<Proveedor, Integer> {
    
}