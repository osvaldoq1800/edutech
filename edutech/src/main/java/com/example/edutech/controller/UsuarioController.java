package com.example.edutech.controller;

import com.example.edutech.model.Autenticacion;
import com.example.edutech.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/perfil")
public class UsuarioController {

    @Autowired
    private UsuarioService servicio;

    // Ver perfil por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> verPorId(@PathVariable Integer id) {
        return servicio.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Ver perfil por usuario
    @GetMapping("/usuario")
    public ResponseEntity<?> verPorUsuario(@RequestParam String usuario) {
        return servicio.buscarPorUsuario(usuario)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Ver perfil por correo
    @GetMapping("/correo")
    public ResponseEntity<?> verPorCorreo(@RequestParam String correo) {
        return servicio.buscarPorCorreo(correo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Editar perfil
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable Integer id, @Valid @RequestBody Autenticacion nuevosDatos) {
        return servicio.editarPerfil(id, nuevosDatos)
                .map(u -> ResponseEntity.ok("Perfil actualizado correctamente."))
                .orElse(ResponseEntity.badRequest().body("No se encontró el usuario."));
    }

    // Eliminar perfil
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        if (servicio.eliminarPorId(id)) {
            return ResponseEntity.ok("Usuario eliminado correctamente.");
        } else {
            return ResponseEntity.badRequest().body("No se encontró el usuario.");
        }
    }
}

