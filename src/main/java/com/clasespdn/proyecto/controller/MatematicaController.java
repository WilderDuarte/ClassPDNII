package com.clasespdn.proyecto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatematicaController {

    // Endpoint: http://localhost:8080/suma?a=5&b=3
    @GetMapping("/suma")
    public int sumar(@RequestParam int a, @RequestParam int b) {
        return a + b;
    }

    // Endpoint: http://localhost:8080/suma?a=5&b=3
    @GetMapping("/resta")
    public int restar(@RequestParam int a, @RequestParam int b) {
        return a - b;
    }

    // Endpoint: http://localhost:8080/multiplicacion?a=4&b=6
    @GetMapping("/multiplicacion")
    public int multiplicar(@RequestParam int a, @RequestParam int b) {
        return a * b;
    }

    // Endpoint: http://localhost:8080/cuadrado?numero=7
    @GetMapping("/cuadrado")
    public int cuadrado(@RequestParam int numero) {
        return numero * numero;
    }
}
