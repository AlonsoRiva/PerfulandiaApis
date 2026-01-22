package com.example.PerfulandiaApiRutas.config;

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
            .title("Perfulandia - API Rutas")
            .version("1.0")
            .description("Servicio para la planificación y optimización de rutas de entrega")
            .contact(new Contact()
                .name("Los Crocodilitos")));
    }
}