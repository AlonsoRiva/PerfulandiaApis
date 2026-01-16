package cl.montoya.registrar_factura.models.dto;

public record VentaDto (int id_venta, int cantidad_producto,
    String fecha_venta, String metodo_pago, int monto_total,
    String nombre_producto) {}

