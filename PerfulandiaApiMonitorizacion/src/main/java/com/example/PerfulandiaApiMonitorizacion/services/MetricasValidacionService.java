package com.example.PerfulandiaApiMonitorizacion.services;

import org.springframework.stereotype.Service;

@Service
public class MetricasValidacionService {


    public boolean sonMetricasValidas(Integer usoCpu, Integer usoMemoria) {
        if (usoCpu == null || usoMemoria == null) {
            return false;
        }
        boolean cpuValida = usoCpu >= 0 && usoCpu <= 100;
        boolean memoriaValida = usoMemoria >= 0;
        
        return cpuValida && memoriaValida;
    }
}