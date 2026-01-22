package com.example.PerfulandiaApiProveedores.services;

import org.springframework.stereotype.Service;

@Service
public class ProveedorValidacionService {

    // Regla: El teléfono debe tener al menos 9 caracteres para ser válido
    public boolean esTelefonoValido(String telefono) {
        return telefono != null && telefono.length() >= 9;
    }
}