package cl.montoya.gestion_devolucion.models.dto;

public record VentaDto (int id_venta, int id_cliente,
    String id_usuario, String estado_venta) {}
