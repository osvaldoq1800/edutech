package com.example.edutech.service;

import com.example.edutech.model.Contenido;
import com.example.edutech.repository.ContenidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContenidoService {

    @Autowired
    private ContenidoRepository contenidoRepository;

    public List<Contenido> obtenerTodos() {
        return contenidoRepository.findAll();
    }

    public Contenido obtenerPorId(Long id) {
        Optional<Contenido> contenido = contenidoRepository.findById(id);
        return contenido.orElse(null);  
    }

    public Contenido guardar(Contenido contenido) {
        return contenidoRepository.save(contenido);
    }

    public void eliminar(Long id) {
        contenidoRepository.deleteById(id);
    }
}
