package com.clasespdn.proyecto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hola")
    public String hola() {
        return "¡Hola desde Spring Boot!";
    }

    // http://localhost:8080/saludo?nombre=Wilder
    @GetMapping("/saludo")
    public String saludar(String nombre) {
        return "Hola " + nombre + ", bienvenido a Spring Boot!";
    }

}
