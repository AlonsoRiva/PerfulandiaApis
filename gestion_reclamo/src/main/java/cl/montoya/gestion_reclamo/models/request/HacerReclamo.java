package cl.montoya.gestion_reclamo.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class HacerReclamo {
    
    @NotBlank
    private String descripcion_reclamo;

    @NotBlank
    private String fecha_reclamo;
    
}
