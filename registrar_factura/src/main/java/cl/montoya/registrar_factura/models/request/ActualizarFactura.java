package cl.montoya.registrar_factura.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ActualizarFactura {

    @NotBlank
    private int id_factura;

    @NotBlank
    private int id_usuario;

    @NotBlank
    private String rut_empresa;

    @NotBlank
    private String razon_social;

    @NotBlank
    private int id_cliente;

    @NotBlank
    private String fecha_emision_factura;

    @NotBlank
    private int total_factura;
    
}
