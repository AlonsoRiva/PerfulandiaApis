package com.example.PerfulandiaApiUsuarios.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import com.example.PerfulandiaApiUsuarios.models.dto.PermisoDto; // 
import com.example.PerfulandiaApiUsuarios.models.entities.Usuario;
import com.example.PerfulandiaApiUsuarios.models.request.ActualizarUsuario;
import com.example.PerfulandiaApiUsuarios.models.request.AgregarUsuario;
import com.example.PerfulandiaApiUsuarios.repositories.UsuarioRepositorio;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private WebClient permisosWebClient; // 

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
        PermisoDto permiso = null;
        try {
            permiso = permisosWebClient.get()
                .uri("/pfl_permisos/{id}", nuevo.getId_permiso())
                .retrieve()
                .bodyToMono(PermisoDto.class)
                .block();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Fallo al conectar con servicio de Permisos: " + e.getMessage());
        }

        if (permiso == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El permiso especificado no existe.");
        }

        Usuario usuario = new Usuario();
        usuario.setNombre(nuevo.getNombre());
        usuario.setApellido(nuevo.getApellido());
        usuario.setEmail(nuevo.getEmail());
        usuario.setPassword(nuevo.getPassword());
        usuario.setId_permiso(nuevo.getId_permiso()); 

        return usuarioRepositorio.save(usuario);
    }

    public Usuario actualizarUsuario(ActualizarUsuario nuevo){
        Usuario usuario = usuarioRepositorio.findById(nuevo.getId_usuario()).orElse(null);
        if (usuario == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado.");
        }
        
        
        usuario.setNombre(nuevo.getNombre());
        usuario.setApellido(nuevo.getApellido());
        usuario.setEmail(nuevo.getEmail());
        
        return usuarioRepositorio.save(usuario); 
    }

    public String eliminarUsuario(int usuarioId){
        if(usuarioRepositorio.existsById(usuarioId)){
            usuarioRepositorio.deleteById(usuarioId);
            return "Usuario eliminado correctamente.";
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado.");
        }
    }
}