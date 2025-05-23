package com.example.edutech.service;

import com.example.edutech.model.Curso;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


/**
 * Implementación del servicio de cursos.
 */
@Service
public class CursoServiceImpl implements CursoService {

    // Lista simulando una base de datos en memoria
    private final List<Curso> cursos = new ArrayList<>();

    @Override
    public Curso crearCurso(Curso curso) {
        cursos.add(curso);
        return curso;
    }

    @Override
    public List<Curso> obtenerTodosLosCursos() {
        return new ArrayList<>(cursos);
    }

    @Override
    public Optional<Curso> obtenerCursoPorId(String id) {
        return cursos.stream()
                .filter(c -> c.getIdCurso().equals(id))
                .findFirst();
    }

    @Override
    public Optional<Curso> actualizarCurso(String id, Curso cursoActualizado) {
        return obtenerCursoPorId(id).map(curso -> {
            curso.setTitulo(cursoActualizado.getTitulo());
            curso.setDescripcion(cursoActualizado.getDescripcion());
            curso.setProfesor(cursoActualizado.getProfesor());
            curso.setFechaInicio(cursoActualizado.getFechaInicio());
            curso.setFechaFin(cursoActualizado.getFechaFin());
            curso.setDisponible(cursoActualizado.isDisponible());
            return curso;
        });
    }

    @Override
    public boolean eliminarCurso(String id) {
        return cursos.removeIf(c -> c.getIdCurso().equals(id));
    }

    @Override
    public List<Curso> obtenerCursosDisponibles() {
        return cursos.stream()
                .filter(Curso::isDisponible)
                .collect(Collectors.toList());
    }

    @Override
    public List<Curso> obtenerCursosPorFecha(LocalDate fecha) {
        return cursos.stream()
                .filter(c -> !fecha.isBefore(c.getFechaInicio()) && !fecha.isAfter(c.getFechaFin()))
                .collect(Collectors.toList());
    }

}
