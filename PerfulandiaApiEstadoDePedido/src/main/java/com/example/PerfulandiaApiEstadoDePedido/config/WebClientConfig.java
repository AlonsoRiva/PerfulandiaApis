package com.example.PerfulandiaApiEstadoDePedido.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient inventarioWebClient() {
        return WebClient.builder()
                .baseUrl("http://inventario-env.eba-iympaunh.us-east-1.elasticbeanstalk.com/")
                .build();
    }

    @Bean
    public WebClient enviosWebClient() {
        return WebClient.builder()
                .baseUrl("http://gestiondeenvios.us-west-2.elasticbeanstalk.com/")
                .build();
    }
}