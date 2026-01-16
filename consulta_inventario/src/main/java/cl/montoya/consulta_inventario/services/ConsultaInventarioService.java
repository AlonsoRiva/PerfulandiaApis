package cl.montoya.consulta_inventario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ConsultaInventarioService {
    
    @Autowired
    private WebClient inventarioWebClient;

    public String ConsultarInventario() {
        return inventarioWebClient.get()
                .uri("/inventario")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

}
