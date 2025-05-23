package com.example.edutech.controller;

import com.example.edutech.model.Autenticacion;
import com.example.edutech.service.AutenticacionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AutenticacionController {

    @Autowired
    private AutenticacionService servicio;

    // REGISTRO
    @PostMapping("/register")
    public ResponseEntity<?> registrar(@Valid @RequestBody Autenticacion usuario) {
        String resultado = servicio.registrarUsuario(usuario);
        if (resultado.contains("correctamente")) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.badRequest().body(resultado);
        }
    }

    // LOGIN
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String usuario, @RequestParam String contrasena) {
        return servicio.login(usuario, contrasena)
                .map(u -> ResponseEntity.ok("Bienvenido " + u.getNombre()))
                .orElse(ResponseEntity.status(401).body("Usuario o contraseña incorrectos"));
    }

    // RECUPERAR CONTRASEÑA
    @PostMapping("/recover")
    public ResponseEntity<?> recuperar(@RequestParam String correo, @RequestParam String nuevaContrasena) {
        boolean resultado = servicio.recuperarContrasena(correo, nuevaContrasena);
        if (resultado) {
            return ResponseEntity.ok("Contraseña actualizada correctamente.");
        } else {
            return ResponseEntity.badRequest().body("Correo no encontrado.");
        }
    }
}

