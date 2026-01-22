package cl.montoya.consulta_inventario.config;

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
            .title("Perfulandia - API Consultar Inventario")
            .version("1.0")
            .description("Servicio de consulta rápida de existencias y disponibilidad de productos")
            .contact(new Contact()
                .name("Los Crocodilitos")));
    }
}