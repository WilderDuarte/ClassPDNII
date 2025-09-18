package com.clasespdn.proyecto.service;

import com.clasespdn.proyecto.dto.UsuarioRequest;
import com.clasespdn.proyecto.dto.UsuarioResponse;
import com.clasespdn.proyecto.model.Usuario;
import com.clasespdn.proyecto.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    // Crear usuario
    public UsuarioResponse crearUsuario(UsuarioRequest request) {
        Usuario usuario = new Usuario();
        usuario.setNombres(request.getNombres());
        usuario.setApellidos(request.getApellidos());
        usuario.setTipoIdentificacion(request.getTipoIdentificacion());
        usuario.setNumeroIdentificacion(request.getNumeroIdentificacion());
        usuario.setTelefono(request.getTelefono());
        usuario.setFechaNacimiento(request.getFechaNacimiento());
        usuario.setEmail(request.getEmail());
        usuario.setContrasena(request.getContrasena()); // SIN encriptación
        usuario.setSexo(request.getSexo());

        Usuario guardado = repo.save(usuario);
        return mapToResponse(guardado);
    }

    // Listar todos
    public List<UsuarioResponse> listarUsuarios() {
        return repo.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // Buscar por ID
    public Optional<UsuarioResponse> buscarPorId(Long id) {
        return repo.findById(id).map(this::mapToResponse);
    }

    // Actualizar usuario
    public Optional<UsuarioResponse> actualizarUsuario(Long id, UsuarioRequest request) {
        return repo.findById(id).map(usuario -> {
            usuario.setNombres(request.getNombres());
            usuario.setApellidos(request.getApellidos());
            usuario.setTipoIdentificacion(request.getTipoIdentificacion());
            usuario.setNumeroIdentificacion(request.getNumeroIdentificacion());
            usuario.setTelefono(request.getTelefono());
            usuario.setFechaNacimiento(request.getFechaNacimiento());
            usuario.setEmail(request.getEmail());
            usuario.setContrasena(request.getContrasena()); // SIN encriptación
            usuario.setSexo(request.getSexo());
            Usuario actualizado = repo.save(usuario);
            return mapToResponse(actualizado);
        });
    }

    // Eliminar usuario
    public boolean eliminarUsuario(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    // Convertir de Entity a Response
    private UsuarioResponse mapToResponse(Usuario usuario) {
        UsuarioResponse resp = new UsuarioResponse();
        resp.setId(usuario.getId());
        resp.setNombres(usuario.getNombres());
        resp.setApellidos(usuario.getApellidos());
        resp.setTipoIdentificacion(usuario.getTipoIdentificacion());
        resp.setNumeroIdentificacion(usuario.getNumeroIdentificacion());
        resp.setTelefono(usuario.getTelefono());
        resp.setFechaNacimiento(usuario.getFechaNacimiento());
        resp.setEmail(usuario.getEmail());
        resp.setSexo(usuario.getSexo());
        return resp;
    }
}
