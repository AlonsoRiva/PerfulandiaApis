package cl.montoya.gestion_devolucion.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.montoya.gestion_devolucion.models.request.InfoVersion;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

@RequestMapping("/")
@RestController
public class BaseController {
    
    @Value("${app.name}")
    private String name;

    @Value("${app.version}")
    private String version;

    @GetMapping("")
    public InfoVersion base() {
        return new InfoVersion(name, version);
    }
    
}
