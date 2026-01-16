package cl.montoya.consulta_inventario.models.dto;

public record InventarioDto(int id_producto, String nombre,
    String genero, int precio, int stock) {}
