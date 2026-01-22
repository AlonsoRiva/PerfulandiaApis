package com.example.PerfulandiaApiPermisos.services;

import org.springframework.stereotype.Service;

@Service
public class PermisoValidacionService {

    // El permiso es válido solo si está todo en mayúsculas
    public boolean esNombreValido(String nombre) {
        return nombre != null && nombre.equals(nombre.toUpperCase());
    }
}