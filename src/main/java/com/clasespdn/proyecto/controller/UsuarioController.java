package com.clasespdn.proyecto.controller;

import com.clasespdn.proyecto.dto.UsuarioRequest;
import com.clasespdn.proyecto.dto.UsuarioResponse;
import com.clasespdn.proyecto.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    // 1. Crear usuario
    // POST → http://localhost:8080/api/usuarios
    @PostMapping
    public ResponseEntity<UsuarioResponse> crearUsuario(@RequestBody UsuarioRequest request) {
        UsuarioResponse creado = service.crearUsuario(request);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    // 2. Listar todos los usuarios
    // GET → http://localhost:8080/api/usuarios
    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> listarUsuarios() {
        return ResponseEntity.ok(service.listarUsuarios());
    }

    // 3. Buscar usuario por id
    // GET → http://localhost:8080/api/usuarios/{id}
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> obtenerUsuario(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 4. Actualizar usuario
    // PUT → http://localhost:8080/api/usuarios/{id}
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponse> actualizarUsuario(
            @PathVariable Long id,
            @RequestBody UsuarioRequest request) {
        return service.actualizarUsuario(id, request)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 5. Eliminar usuario
    // DELETE → http://localhost:8080/api/usuarios/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        if (service.eliminarUsuario(id)) {
            return ResponseEntity.noContent().build(); // 204
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
