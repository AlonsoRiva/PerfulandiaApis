package cl.montoya.gestion_devolucion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean("VentaWebClient")
    public WebClient VentawebClient() {
        return WebClient.builder().baseUrl("http://registrar-venta.us-east-1.elasticbeanstalk.com").build();
    }
    
    @Bean("ClienteWebClient")
    public WebClient ClientewebClient() {
        return WebClient.builder().baseUrl("http://cliente.us-east-1.elasticbeanstalk.com").build();
    }
}

