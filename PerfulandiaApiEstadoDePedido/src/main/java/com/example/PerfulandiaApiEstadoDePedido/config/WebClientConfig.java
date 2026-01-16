package com.example.PerfulandiaApiEstadoDePedido.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient inventarioWebClient() {
        return WebClient.builder()
                .baseUrl("http://localhost:2031/inventario")
                .build();
    }

    @Bean
    public WebClient enviosWebClient() {
        return WebClient.builder()
                .baseUrl("http://localhost:2030/envios")
                .build();
    }
}