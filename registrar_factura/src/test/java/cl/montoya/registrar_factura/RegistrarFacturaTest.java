package cl.montoya.registrar_factura;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import cl.montoya.registrar_factura.models.entities.Factura;
import cl.montoya.registrar_factura.models.request.AgregarFactura;

public class RegistrarFacturaTest {

    @Test
    void crearFactura() {

        AgregarFactura agregar_factura = new AgregarFactura();
        agregar_factura.setId_usuario(1);
        agregar_factura.setRut_empresa("12345678-9");
        agregar_factura.setRazon_social("Mi Empresa");
        agregar_factura.setId_cliente(10);
        agregar_factura.setFecha_emision_factura("2026-01-23");
        agregar_factura.setTotal_factura(5000);

        Factura factura = new Factura();
        factura.setId_usuario(agregar_factura.getId_usuario());
        factura.setRut_empresa(agregar_factura.getRut_empresa());
        factura.setRazon_social(agregar_factura.getRazon_social());
        factura.setId_cliente(agregar_factura.getId_cliente());
        factura.setFecha_emision_factura(agregar_factura.getFecha_emision_factura());
        factura.setTotal_factura(agregar_factura.getTotal_factura());

        assertThat(factura).isNotNull();
        assertThat(factura.getRazon_social()).isEqualTo("Mi Empresa");
        assertThat(factura.getTotal_factura()).isEqualTo(5000);
    }
}
