package com.example.PerfulandiaApiEstadoDePedido.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.PerfulandiaApiEstadoDePedido.models.entities.EstadoPedido;

@Repository
public interface EstadoPedidoRepositorio extends JpaRepository<EstadoPedido, Integer> {
}