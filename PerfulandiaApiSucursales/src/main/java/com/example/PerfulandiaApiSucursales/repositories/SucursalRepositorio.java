package com.example.PerfulandiaApiSucursales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.PerfulandiaApiSucursales.models.entities.Sucursal;

@Repository
public interface SucursalRepositorio extends JpaRepository<Sucursal, Integer> {
}