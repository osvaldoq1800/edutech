package com.example.edutech.service;

import com.example.edutech.model.Curso;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


/**
 * Interfaz que define las operaciones del servicio para manejar cursos.
 */
public interface CursoService {

    /**
     * Crea y guarda un nuevo curso.
     * @param curso El curso a crear
     * @return El curso creado
     */
    Curso crearCurso(Curso curso);

    /**
     * Devuelve todos los cursos registrados.
     * @return Lista de cursos
     */
    List<Curso> obtenerTodosLosCursos();

    /**
     * Busca un curso por su ID.
     * @param id ID del curso
     * @return Curso encontrado o vacío si no existe
     */
    Optional<Curso> obtenerCursoPorId(String id);

    /**
     * Actualiza un curso existente.
     * @param id ID del curso a actualizar
     * @param cursoActualizado Curso con nuevos datos
     * @return Curso actualizado o vacío si no se encontró
     */
    Optional<Curso> actualizarCurso(String id, Curso cursoActualizado);

    /**
     * Elimina un curso por su ID.
     * @param id ID del curso a eliminar
     * @return true si se eliminó correctamente
     */
    boolean eliminarCurso(String id);

    /**
     * Obtiene cursos disponibles.
     * @return Lista de cursos disponibles
     */
    List<Curso> obtenerCursosDisponibles();

    /**
     * Obtiene cursos activos en una fecha específica.
     * @param fecha Fecha a evaluar
     * @return Lista de cursos activos
     */
    List<Curso> obtenerCursosPorFecha(LocalDate fecha);
}
