package cl.montoya.cliente.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CrearCliente {
    
    @NotBlank
    private String nombre_cliente;

    @NotBlank
    private String apellido_cliente;

    @NotBlank
    private String direccion_cliente;

    @NotBlank
    private String telefono_cliente;

    @NotBlank
    private String email_cliente;

    @NotBlank
    private String fecha_registro_cliente;
    
}
