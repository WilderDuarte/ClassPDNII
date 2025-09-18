package com.clasespdn.proyecto.repository;

import com.clasespdn.proyecto.model.Usersejm;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsersejmRepository extends JpaRepository<Usersejm, Long> {
    Optional<Usersejm> findByEmail(String email);
}