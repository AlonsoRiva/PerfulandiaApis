package cl.montoya.gestion_devolucion.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ActualizarDevolucion {

    @NotBlank
    private int id_devolucion;

    @NotBlank
    private int id_usuario;

    @NotBlank
    private int id_cliente;

    @NotBlank
    private int id_venta;

    @NotBlank
    private String motivo_devolucion;

    @NotBlank
    private String fecha_devolucion;

    @NotBlank
    private int monto_reembolsado;

    @NotBlank
    private String estado_venta;
    
}
