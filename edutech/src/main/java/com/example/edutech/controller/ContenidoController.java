package com.example.edutech.controller;

import com.example.edutech.model.Contenido;
import com.example.edutech.service.ContenidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contenidos")
public class ContenidoController {
     @Autowired
    private ContenidoService contenidoService;

    @GetMapping
    public List<Contenido> listarTodos() {
        return contenidoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contenido> obtenerPorId(@PathVariable Long id) {
        Contenido contenido = contenidoService.obtenerPorId(id);
        if (contenido != null) {
            return ResponseEntity.ok(contenido);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Contenido crearContenido(@RequestBody Contenido contenido) {
        return contenidoService.guardar(contenido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contenido> actualizarContenido(@PathVariable Long id, @RequestBody Contenido contenido) {
        Contenido contenidoExistente = contenidoService.obtenerPorId(id);
        if (contenidoExistente != null) {
            contenido.setId(id); // Asegura que el id se mantenga
            Contenido actualizado = contenidoService.guardar(contenido);
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarContenido(@PathVariable Long id) {
        Contenido contenidoExistente = contenidoService.obtenerPorId(id);
        if (contenidoExistente != null) {
            contenidoService.eliminar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
