package com.example.PerfulandiaApiUsuarios.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient permisosWebClient(){
        return WebClient.builder().baseUrl("http://gestiondepermisos.us-east-1.elasticbeanstalk.com/").build();

    }
}