package com.example.edutech.repository;

import com.example.edutech.model.Autenticacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutenticacionUsuario extends JpaRepository<Autenticacion, Integer> {
    Autenticacion findByUsuario(String usuario);
    Autenticacion findByCorreo(String correo);
}

