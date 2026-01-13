package com.example.PerfulandiaApiUsuarios.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.PerfulandiaApiUsuarios.models.entities.Usuario;
import com.example.PerfulandiaApiUsuarios.models.request.ActualizarUsuario;
import com.example.PerfulandiaApiUsuarios.models.request.AgregarUsuario;
import com.example.PerfulandiaApiUsuarios.repositories.UsuarioRepositorio;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public List<Usuario> ObtenerTodoslosUsuarios(){

        return usuarioRepositorio.findAll();
    }

    public Usuario obtenerUsuarioPorId(int usuarioId){
        Usuario usuario = usuarioRepositorio.findById(usuarioId).orElse(null);
        if (usuario == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado.");
        }
        return usuario;
    }


    public Usuario agregarNuevoUsuario(AgregarUsuario nuevo){
        Usuario usuario = new Usuario();
        usuario.setNombre(nuevo.getNombre());
        usuario.setApellido(nuevo.getApellido());
        usuario.setEmail(nuevo.getEmail());
        usuario.setPassword(nuevo.getPassword());
        return usuarioRepositorio.save(usuario);
    
    }


    public Usuario actualizarUsuario(ActualizarUsuario nuevo){
        Usuario usuario = usuarioRepositorio.findById(nuevo.getId_usuario()).orElse(null);
        if (usuario == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado.");
        }else{
            usuario.setNombre(nuevo.getNombre());
            usuario.setApellido(nuevo.getApellido());
            usuario.setEmail(nuevo.getEmail());
            return usuarioRepositorio.save(usuario);
        }   
    }

    public String eliminarUsuario(int usuarioId){
        if(usuarioRepositorio.existsById(usuarioId)){
            usuarioRepositorio.deleteById(usuarioId);
            return "Nombre Eliminado Correctamente.";
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado.");
        }
    }
 }