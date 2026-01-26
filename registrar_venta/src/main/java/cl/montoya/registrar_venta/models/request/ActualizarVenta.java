package cl.montoya.registrar_venta.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ActualizarVenta {

    @NotBlank
    private int id_venta;

    @NotBlank
    private int id_usuario;

    @NotBlank
    private int id_producto;

    @NotBlank
    private String nombre_producto;

    @NotBlank
    private int cantidad_producto;

    @NotBlank
    private int id_cliente;

    @NotBlank
    private String nombre_cliente;

    @NotBlank
    private String metodo_pago;

    @NotBlank
    private String fecha_venta;

    @NotBlank
    private int monto_total;

    @NotBlank
    private String estado_venta;

}
