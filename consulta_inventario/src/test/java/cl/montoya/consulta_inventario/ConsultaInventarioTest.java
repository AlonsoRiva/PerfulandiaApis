package cl.montoya.consulta_inventario;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import cl.montoya.consulta_inventario.controller.ConsultaInventarioController;
import cl.montoya.consulta_inventario.services.ConsultaInventarioService;

import static org.mockito.Mockito.when;

@WebMvcTest(ConsultaInventarioController.class)
public class ConsultaInventarioTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ConsultaInventarioService consultaInventarioService;

    @Test
    void consultarInventario_200ok() throws Exception {
        when(consultaInventarioService.ConsultarInventario())
            .thenReturn("Inventario funciona");

        mockMvc.perform(get("/consulta_inventario"))
               .andExpect(status().isOk());
    }
}
