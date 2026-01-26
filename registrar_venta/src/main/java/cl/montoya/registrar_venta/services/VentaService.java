package cl.montoya.registrar_venta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import cl.montoya.registrar_venta.models.entities.Venta;
import cl.montoya.registrar_venta.models.request.AgregarVenta;
import cl.montoya.registrar_venta.models.request.ActualizarVenta;
import cl.montoya.registrar_venta.repositories.VentaRepository;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    public List<Venta> TodasLasVentas() {
        return ventaRepository.findAll();
    }

    public Venta ObtenerVentaPorId(int id_venta) {
        Venta venta = ventaRepository.findById(id_venta).orElse(null);
        if (venta == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Venta no encontrada");
        }
        return venta;
    }

    public Venta AgregarVenta(AgregarVenta nueva_venta) {
        Venta venta = new Venta();
        venta.setId_usuario(nueva_venta.getId_usuario());
        venta.setId_producto(nueva_venta.getId_producto());
        venta.setNombre_producto(nueva_venta.getNombre_producto());
        venta.setCantidad_producto(nueva_venta.getCantidad_producto());
        venta.setId_cliente(nueva_venta.getId_cliente());
        venta.setNombre_cliente(nueva_venta.getNombre_cliente());
        venta.setMetodo_pago(nueva_venta.getMetodo_pago());
        venta.setFecha_venta(nueva_venta.getFecha_venta());
        venta.setMonto_total(nueva_venta.getMonto_total());
        venta.setEstado_venta(nueva_venta.getEstado_venta());
        return ventaRepository.save(venta);
    }

    public Venta ActualizarVenta(ActualizarVenta venta_actualizada) {
        Venta venta = ventaRepository.findById(venta_actualizada.getId_venta()).orElse(null);
        if (venta == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Venta no encontrada");
        }else{
        venta.setId_usuario(venta_actualizada.getId_usuario());
        venta.setId_producto(venta_actualizada.getId_producto());
        venta.setNombre_producto(venta_actualizada.getNombre_producto());
        venta.setCantidad_producto(venta_actualizada.getCantidad_producto());
        venta.setId_cliente(venta_actualizada.getId_cliente());
        venta.setNombre_cliente(venta_actualizada.getNombre_cliente());
        venta.setMetodo_pago(venta_actualizada.getMetodo_pago());
        venta.setFecha_venta(venta_actualizada.getFecha_venta());
        venta.setMonto_total(venta_actualizada.getMonto_total());
        venta.setEstado_venta(venta_actualizada.getEstado_venta());
        return ventaRepository.save(venta);
        }
    }
}
