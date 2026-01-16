package com.example.PerfulandiaApiReportes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.PerfulandiaApiReportes.models.entities.Reporte;
import java.util.List;

@Repository
public interface ReporteRepositorio extends JpaRepository<Reporte, Integer> {
    // Método extra útil para buscar reportes por sucursal
    List<Reporte> findByIdSucursal(Integer idSucursal);
}