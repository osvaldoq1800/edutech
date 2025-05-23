package com.example.edutech.service;

import com.example.edutech.model.Autenticacion;
import com.example.edutech.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    // Ver perfil
    public Optional<Autenticacion> buscarPorId(Integer id) {
        return repo.findById(id);
    }

    public Optional<Autenticacion> buscarPorUsuario(String usuario) {
        return Optional.ofNullable(repo.findByUsuario(usuario));
    }

    public Optional<Autenticacion> buscarPorCorreo(String correo) {
        return Optional.ofNullable(repo.findByCorreo(correo));
    }

    // Editar perfil
    public Optional<Autenticacion> editarPerfil(Integer id, Autenticacion nuevosDatos) {
        return repo.findById(id).map(user -> {
            user.setNombre(nuevosDatos.getNombre());
            user.setApellido(nuevosDatos.getApellido());
            user.setCorreo(nuevosDatos.getCorreo());
            user.setContrasena(nuevosDatos.getContrasena());
            user.setUsuario(nuevosDatos.getUsuario());
            user.setNumeroCelular(nuevosDatos.getNumeroCelular());
            user.setEdad(nuevosDatos.getEdad());
            return repo.save(user);
        });
    }

    // Eliminar perfil
    public boolean eliminarPorId(Integer id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}

