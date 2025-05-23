package com.example.edutech.controller;

import com.example.edutech.model.Curso;
import com.example.edutech.service.CursoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para la gestión de cursos.
 */
@RestController
@RequestMapping("/api/cursos")


public class CursoController {
    
    @Autowired
    private CursoService cursoService;

    // Crear un curso
    @PostMapping
    public Curso crearCurso(@RequestBody Curso curso) {
        return cursoService.crearCurso(curso);
    }

    // Obtener todos los cursos
    @GetMapping
    public List<Curso> obtenerTodos() {
        return cursoService.obtenerTodosLosCursos();
    }

    // Obtener curso por ID
    @GetMapping("/{id}")
    public Optional<Curso> obtenerPorId(@PathVariable String id) {
        return cursoService.obtenerCursoPorId(id);
    }

    // Actualizar curso
    @PutMapping("/{id}")
    public Optional<Curso> actualizarCurso(@PathVariable String id, @RequestBody Curso cursoActualizado) {
        return cursoService.actualizarCurso(id, cursoActualizado);
    }

    // Eliminar curso
    @DeleteMapping("/{id}")
    public boolean eliminarCurso(@PathVariable String id) {
        return cursoService.eliminarCurso(id);
    }

    // Obtener cursos disponibles
    @GetMapping("/disponibles")
    public List<Curso> obtenerCursosDisponibles() {
        return cursoService.obtenerCursosDisponibles();
    }

    // Obtener cursos activos en una fecha
    @GetMapping("/activos/{fecha}")
    public List<Curso> obtenerPorFecha(@PathVariable String fecha) {
        return cursoService.obtenerCursosPorFecha(LocalDate.parse(fecha));
    }

}
