package com.example.edutech.service;

import com.example.edutech.model.Autenticacion;
import com.example.edutech.repository.AutenticacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticacionService {

    @Autowired
    private AutenticacionRepository repo;

    // REGISTRO
    public String registrarUsuario(Autenticacion usuario) {
        if (repo.findByUsuario(usuario.getUsuario()) != null) {
            return "Usuario ya existe.";
        }
        if (repo.findByCorreo(usuario.getCorreo()) != null) {
            return "Correo ya registrado.";
        }
        repo.save(usuario);
        return "Usuario registrado correctamente.";
    }

    // LOGIN
    public Optional<Autenticacion> login(String usuario, String contrasena) {
        Autenticacion encontrado = repo.findByUsuario(usuario);
        if (encontrado != null && encontrado.getContrasena().equals(contrasena)) {
            return Optional.of(encontrado);
        }
        return Optional.empty();
    }

    // RECUPERAR CONTRASEÑA
    public boolean recuperarContrasena(String correo, String nuevaContrasena) {
        Autenticacion usuario = repo.findByCorreo(correo);
        if (usuario != null) {
            usuario.setContrasena(nuevaContrasena);
            repo.save(usuario);
            return true;
        }
        return false;
    }
}
