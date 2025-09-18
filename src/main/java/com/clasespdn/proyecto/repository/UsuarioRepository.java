package com.clasespdn.proyecto.repository;

import com.clasespdn.proyecto.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByNumeroIdentificacion(String numeroIdentificacion);
}
