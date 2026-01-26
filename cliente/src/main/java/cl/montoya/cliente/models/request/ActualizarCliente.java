package cl.montoya.cliente.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ActualizarCliente {

    @NotBlank
    private int id_cliente;

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

}
