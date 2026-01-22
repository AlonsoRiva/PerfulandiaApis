package com.example.PerfulandiaApiRespaldos.services;

import org.springframework.stereotype.Service;

@Service
public class RespaldoValidacionService {

    // Regla: El archivo es válido solo si termina en ".sql"
    public boolean esArchivoValido(String nombreArchivo) {
        return nombreArchivo != null && nombreArchivo.endsWith(".sql");
    }
}