package cl.montoya.consulta_inventario.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.montoya.consulta_inventario.services.ConsultaInventarioService;
import org.springframework.web.bind.annotation.GetMapping;


@RequestMapping("/consulta_inventario")
@RestController
public class ConsultaInventarioController {
    
    @Autowired
    private ConsultaInventarioService consultaInventarioService;

    @GetMapping("")
    public String ConsultarInventario() {
        return consultaInventarioService.ConsultarInventario();
    }
    

}
