package com.example.edutech.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Idusuario;

    @NotBlank(message = "Este RUT no puede estar vacio")
    @Column(unique = true, length = 12, nullable = false)
    private String Run;

    @NotBlank(message = "Este campo no puede estar vacio")
    @Column(nullable = false)
    private String Nombre;

    @NotBlank(message = "Este campo no puede estar vacio")
    @Column(nullable = false)
    private String Apellido;

    @NotBlank(message = "Este campo no puede estar vacio")
    @Column(nullable = false)
    private String Correo;

    @NotBlank(message = "Este campo no puede estar vacio")
    @Size(min = 8, max = 32, message = "La contraseña debe tener entre 8 a 16 caracteres")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\\\d).{8,}$", message = "La contraseña debe tener almenos una mayúscula, una minúscula y un número")
    @Column(name = "Contraseña", nullable = false)
    private String Contrasena;

    @NotBlank(message = "Este campo no puede estar vacio")
    @Column(name = "Usuario", nullable = false)
    private String Usuario;

    @NotBlank(message = "Este campo no puede estar vacio")
    @Column(name = "Numero Celular", nullable = false)
    private String NumeroCelular;

    @NotBlank(message = "Este campo no puede estar vacio")
    @Column(nullable = false)
    private Data Edad;

}
