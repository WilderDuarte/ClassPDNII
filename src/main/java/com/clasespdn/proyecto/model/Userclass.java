package com.clasespdn.proyecto.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="userclass", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"email"})
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Userclass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(nullable = false, unique = true)
    private String email;

    private String telefono;

}
