package com.example.PerfulandiaApiSucursales.service;

import com.example.PerfulandiaApiSucursales.models.entities.Sucursal;
import com.example.PerfulandiaApiSucursales.models.request.AgregarSucursal;

public class SucursalFactoryService {

    public Sucursal crearSucursal(AgregarSucursal request) {

        Sucursal s = new Sucursal();
        s.setNombre(request.getNombre());
        s.setDireccion(request.getDireccion());
        s.setHorarioAtencion(request.getHorarioAtencion());
        s.setPersonalAsignado(request.getPersonalAsignado());
        s.setPoliticas(request.getPoliticas());

        return s;
    }
}
