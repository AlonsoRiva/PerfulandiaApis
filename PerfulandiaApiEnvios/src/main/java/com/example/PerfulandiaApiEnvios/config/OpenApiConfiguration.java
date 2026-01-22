package com.example.PerfulandiaApiEnvios.config;

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
            .title("Perfulandia - API Envíos")
            .version("1.0")
            .description("Servicio para la gestión logística y despachos de pedidos")
            .contact(new Contact()
                .name("Los Crocodilitos")));
    }
}