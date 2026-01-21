package com.example.PerfulandiaApiUsuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PerfulandiaApiUsuarios.models.entities.Usuario;
import com.example.PerfulandiaApiUsuarios.models.request.ActualizarUsuario;
import com.example.PerfulandiaApiUsuarios.models.request.AgregarUsuario;
import com.example.PerfulandiaApiUsuarios.services.UsuarioService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("/usuarios")
@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("")
    public List<Usuario> obtenerTodo(){
        return usuarioService.ObtenerTodoslosUsuarios();

    }
    
    @GetMapping("/{idUsuario}")
    public Usuario getMethodName(@PathVariable int idUsuario) {
        return usuarioService.obtenerUsuarioPorId(idUsuario);
    }

    @PostMapping("")
    public Usuario AgregarUsuario(@RequestBody  AgregarUsuario nueva) {
        
        return usuarioService.agregarNuevoUsuario(nueva);
    }
    
    @PutMapping("")
    public Usuario actualizarUsuario(@RequestBody ActualizarUsuario nueva) {
        
        return usuarioService.actualizarUsuario(nueva);
    }

    @DeleteMapping("/{idUsuario}")
    public String eliminarUsuario(@PathVariable int idUsuario){
        return usuarioService.eliminarUsuario(idUsuario);

    }
}
