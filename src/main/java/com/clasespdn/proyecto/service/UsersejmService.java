package com.clasespdn.proyecto.service;

import com.clasespdn.proyecto.dto.UsersejmRequest;
import com.clasespdn.proyecto.dto.UsersejmResponse;
import com.clasespdn.proyecto.model.Usersejm;
import com.clasespdn.proyecto.repository.UsersejmRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersejmService {

    private final UsersejmRepository repository;

    public UsersejmService(UsersejmRepository repository) {
        this.repository = repository;
    }

    // Crear un nuevo usuario
    public UsersejmResponse crear(UsersejmRequest request) {
        Usersejm entity = new Usersejm();
        entity.setNombre(request.getNombre());
        entity.setEmail(request.getEmail());
        entity.setTelefono(request.getTelefono());

        Usersejm guardado = repository.save(entity);
        return new UsersejmResponse(guardado.getId(), guardado.getNombre(), guardado.getEmail(), guardado.getTelefono());
    }

    // Listar todos los usuarios
    public List<UsersejmResponse> listar() {
        return repository.findAll()
                .stream()
                .map(u -> new UsersejmResponse(u.getId(), u.getNombre(), u.getEmail(), u.getTelefono()))
                .collect(Collectors.toList());
    }

    // Buscar usuario por ID
    public UsersejmResponse buscarPorId(Long id) {
        Usersejm entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id " + id));
        return new UsersejmResponse(entity.getId(), entity.getNombre(), entity.getEmail(), entity.getTelefono());
    }

    // Actualizar usuario por ID
    public UsersejmResponse actualizar(Long id, UsersejmRequest request) {
        Usersejm entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id " + id));

        entity.setNombre(request.getNombre());
        entity.setEmail(request.getEmail());
        entity.setTelefono(request.getTelefono());

        Usersejm actualizado = repository.save(entity);
        return new UsersejmResponse(actualizado.getId(), actualizado.getNombre(), actualizado.getEmail(), actualizado.getTelefono());
    }

    // Eliminar usuario por ID
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Usuario no encontrado con id " + id);
        }
        repository.deleteById(id);
    }
}
