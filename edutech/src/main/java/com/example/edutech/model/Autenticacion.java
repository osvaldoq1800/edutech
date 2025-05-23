package com.example.edutech.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Autenticacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idusuario;

    @NotBlank(message = "Este RUT no puede estar vacio")
    @Column(unique = true, length = 12, nullable = false)
    private String rut;

    @NotBlank(message = "Este campo no puede estar vacio")
    @Column(nullable = false)
    private String nombre;

    @NotBlank(message = "Este campo no puede estar vacio")
    @Column(nullable = false)
    private String apellido;

    @NotBlank(message = "Este campo no puede estar vacio")
    @Column(nullable = false)
    private String correo;

    @NotBlank(message = "Este campo no puede estar vacio")
    @Size(min = 8, max = 32, message = "La contraseña debe tener entre 8 a 16 caracteres")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\\\d).{8,}$", message = "La contraseña debe tener almenos una mayúscula, una minúscula y un número")
    @Column(name = "Contraseña", nullable = false)
    private String contrasena;

    @NotBlank(message = "Este campo no puede estar vacio")
    @Column(name = "Usuario", nullable = false)
    private String usuario;

    @NotBlank(message = "Este campo no puede estar vacio")
    @Column(name = "Numero Celular", nullable = false)
    private String NumeroCelular;

    @NotBlank(message = "Este campo no puede estar vacio")
    @Column(nullable = false)
    private Integer edad;

}
