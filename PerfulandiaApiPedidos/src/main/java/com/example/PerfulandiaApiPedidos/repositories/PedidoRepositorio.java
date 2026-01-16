package com.example.PerfulandiaApiPedidos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.PerfulandiaApiPedidos.models.entities.Pedidos;

import java.util.List;

@Repository
public interface PedidoRepositorio extends JpaRepository<Pedidos, Integer> {
    // Para ver pedidos de una sucursal específica
    List<Pedidos> findByIdSucursal(int idSucursal);
    
    // Para filtrar por estado (ej: Ver todos los PENDIENTES para autorizar)
    List<Pedidos> findByEstado(String estado);
}