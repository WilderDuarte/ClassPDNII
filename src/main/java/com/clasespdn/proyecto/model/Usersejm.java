package com.clasespdn.proyecto.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usersejm", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usersejm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(nullable = false, unique = true)
    private String email;

    private String telefono;
}