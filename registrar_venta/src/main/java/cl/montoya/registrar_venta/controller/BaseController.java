package cl.montoya.registrar_venta.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cl.montoya.registrar_venta.models.dto.VersionInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/")
public class BaseController {

    @Value("${app.name}")
    private String nombre;

    @Value("${app.version}")
    private String version;

    @GetMapping("")
    public VersionInfo base() {
        return new VersionInfo(nombre, version);
    }
}