package com.clasespdn.proyecto.repository;

import com.clasespdn.proyecto.model.Userclass;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserclassRepository extends JpaRepository<Userclass, Long> {
    Optional<Userclass> findByEmail(String email);
}
