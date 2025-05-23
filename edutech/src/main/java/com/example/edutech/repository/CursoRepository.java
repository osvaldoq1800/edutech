package com.example.edutech.repository;


import com.example.edutech.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, String> {
    // JpaRepository ya te da los métodos básicos CRUD
    // Puedes agregar consultas personalizadas si las necesitas
}
