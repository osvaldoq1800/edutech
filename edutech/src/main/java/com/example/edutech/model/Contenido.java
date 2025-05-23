package com.example.edutech.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Table(name = "contenido")
@Data                       // Genera getters, setters, toString, equals y hashCode automáticamente
@NoArgsConstructor          // Genera constructor sin argumentos
@AllArgsConstructor         // Genera constructor con todos los argumentos

public class Contenido {
    
    // Identificador único del contenido (clave primaria)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Título de la materia o unidad (ej: "Introducción a Java")
    private String titulo;

    // Breve descripción del contenido
    private String descripcion;

    // Nombre del módulo si el curso está dividido en módulos
    private String modulo;

    // Duración estimada en horas para completar este contenido
    private int duracionHoras;

    // Fecha en la que se publica o habilita este contenido
    private LocalDate fechaPublicacion;

    // Recursos complementarios como enlaces, PDFs o videos
    private String recursos;

    // Nombre del profesor responsable del contenido
    private String profesor;

    // Relación muchos-a-uno con la clase Curso
    // Varios contenidos pueden pertenecer a un mismo curso
    @ManyToOne
    @JoinColumn(name = "curso_id") // Clave foránea que une al curso
    private Curso curso;

}
