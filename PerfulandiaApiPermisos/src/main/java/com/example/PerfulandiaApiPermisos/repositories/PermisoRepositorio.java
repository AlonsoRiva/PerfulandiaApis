package com.example.PerfulandiaApiPermisos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.PerfulandiaApiPermisos.models.entities.Permiso;

@Repository
public interface PermisoRepositorio extends JpaRepository<Permiso, Integer> {
}