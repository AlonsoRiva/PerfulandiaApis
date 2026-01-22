package com.example.PerfulandiaApiEnvios.services;

import org.springframework.stereotype.Service;

@Service
public class EnvioStateService {

    // Regla de Negocio: Si un envío ya está "ENTREGADO", no se puede cambiar su estado.
    // Es un estado final.
    public boolean esCambioEstadoValido(String estadoActual, String nuevoEstado) {
        
        // Normalizamos a mayúsculas para evitar errores por "entregado" vs "ENTREGADO"
        String actual = estadoActual.toUpperCase();
        
        if (actual.equals("ENTREGADO")) {
            // Si ya se entregó, prohibido cambiar a cualquier otra cosa
            return false;
        }

        // Cualquier otro cambio es permitido (por ahora)
        return true;
    }
}