package cl.montoya.registrar_venta.config;

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
            .title("Perfulandia - API Registrar Venta")
            .version("1.0")
            .description("Servicio encargado de procesar y registrar las transacciones de ventas de perfumes")
            .contact(new Contact()
                .name("Los Crocodilitos")));
    }
}