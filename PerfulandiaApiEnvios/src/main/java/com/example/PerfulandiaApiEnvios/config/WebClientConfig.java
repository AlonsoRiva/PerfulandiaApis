package com.example.PerfulandiaApiEnvios.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient sucursalWebClient() {
        return WebClient.builder()
                .baseUrl("http://gestiondesucursales.us-west-2.elasticbeanstalk.com/")
                .build();
    }
}