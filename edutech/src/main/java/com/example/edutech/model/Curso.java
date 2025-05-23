package com.example.edutech.model;

import java.time.LocalDate;
import java.util.List;

// Corrige la importación: debe ser con 'Id' con mayúscula y sin la línea extra incorrecta
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cursos") // Nombre de la tabla en Oracle DB
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Curso {  
    
    @Id
    private String idCurso;         // Identificador único del curso
    
    private String titulo;          // Título del curso
    
    private String descripcion;     // Descripción del curso
    
    private String profesor;        // Nombre o ID del profesor a cargo
    
    private LocalDate fechaInicio;  // Fecha de inicio del curso
    
    private LocalDate fechaFin;     // Fecha de finalización
    
    private boolean disponible;     // Indica si el curso está disponible

    
    // Lista de contenidos asociados a este curso (relación uno a muchos)
    // El atributo "curso" en la clase Contenido es el propietario de la relación
    @OneToMany(mappedBy = "curso") 
    private List<Contenido> contenidos;
    
}
