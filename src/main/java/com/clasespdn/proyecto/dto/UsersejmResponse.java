package com.clasespdn.proyecto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsersejmResponse {
    private Long id;
    private String nombre;
    private String email;
    private String telefono;
}