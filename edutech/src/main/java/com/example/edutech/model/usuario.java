package com.example.edutech.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class usuario {

    @Id
    private int idusuario;
    private String usuario;
    private String contraseña;
    private String correo;
    private int edad;
    private String numero;

}
