package com.example.PerfulandiaApiUsuarios.services;

import org.springframework.stereotype.Service;

@Service
public class ValidacionService {
    
    // Lógica simple: La clave es segura si no está vacía y tiene 8 o más caracteres
    public boolean esClaveSegura(String clave) {
        return clave != null && clave.length() >= 8;
    }
}