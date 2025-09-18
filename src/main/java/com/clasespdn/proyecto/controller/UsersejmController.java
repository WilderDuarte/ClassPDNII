package com.clasespdn.proyecto.controller;

import com.clasespdn.proyecto.dto.UsersejmRequest;
import com.clasespdn.proyecto.dto.UsersejmResponse;
import com.clasespdn.proyecto.service.UsersejmService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usersejm")
public class UsersejmController {

    private final UsersejmService service;

    public UsersejmController(UsersejmService service) {
        this.service = service;
    }

    /**
     * POST /usersejm
     * Crea un nuevo usuario
     */
    @PostMapping
    public UsersejmResponse crear(@RequestBody UsersejmRequest request) {
        return service.crear(request);
    }

    /**
     * GET /usersejm
     * Lista todos los usuarios
     */
    @GetMapping
    public List<UsersejmResponse> listar() {
        return service.listar();
    }

    /**
     * GET /usersejm/{id}
     * Busca un usuario por su ID
     */
    @GetMapping("/{id}")
    public UsersejmResponse buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    /**
     * PUT /usersejm/{id}
     * Actualiza un usuario existente por su ID
     */
    @PutMapping("/{id}")
    public UsersejmResponse actualizar(@PathVariable Long id, @RequestBody UsersejmRequest request) {
        return service.actualizar(id, request);
    }

    /**
     * DELETE /usersejm/{id}
     * Elimina un usuario por su ID
     */
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
