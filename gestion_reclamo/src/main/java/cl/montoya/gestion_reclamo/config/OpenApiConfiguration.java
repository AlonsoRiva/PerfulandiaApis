package cl.montoya.gestion_reclamo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI documentacionOpenApi(){
        return new OpenAPI()
            .info(new Info()
            .title("Perfulandia - API Gestión Reclamos")
            .version("1.0")
            .description("Servicio para el registro y seguimiento de quejas y reclamos de clientes")
            .contact(new Contact()
                .name("Los Crocodilitos")));
    }
}