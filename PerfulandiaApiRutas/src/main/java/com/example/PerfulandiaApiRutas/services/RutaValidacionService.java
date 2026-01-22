package com.example.PerfulandiaApiRutas.services;

import org.springframework.stereotype.Service;

@Service
public class RutaValidacionService {

    // Regla simple: La distancia debe ser mayor a 0 para ser válida
    public boolean esDistanciaValida(int kilometros) {
        return kilometros > 0;
    }
}