package cl.montoya.consulta_inventario.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Bean
    public WebClient webClient() {
        return WebClient.builder().baseUrl("http://inventario-env.eba-iympaunh.us-east-1.elasticbeanstalk.com").build();
    }
}
