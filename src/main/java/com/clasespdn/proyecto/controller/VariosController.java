package com.clasespdn.proyecto.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/varios")
public class VariosController {

    // 1. Conversor de Monedas
    // Endpoint: GET /varios/convertir/{usd}
    @GetMapping("/convertir/{usd}")
    public String convertir(@PathVariable double usd) {
        double tasa = 4200; // Ejemplo de tasa fija
        double cop = usd * tasa;
        return usd + " USD son " + cop + " COP";
    }

    // 2. Generador de Números Aleatorios
    // Endpoint: GET /varios/aleatorio
    @GetMapping("/aleatorio")
    public int aleatorio() {
        return (int)(Math.random() * 100 + 1);
    }

    // 3. Lista de Estudiantes
    // Endpoint: GET /varios/estudiantes
    @GetMapping("/estudiantes")
    public List<String> estudiantes() {
        return List.of("Ana", "Luis", "Pedro", "Julio");
    }

    // 4. Mini-Encuesta
    // Endpoint: GET /varios/encuesta?nombre=Ana&edad=20
    @GetMapping("/encuesta")
    public String encuesta(@RequestParam String nombre, @RequestParam int edad) {
        return "Hola " + nombre + ", tienes " + edad + " años.";
    }

    // 5. Reloj del Servidor
    // Endpoint: GET /varios/hora
    @GetMapping("/hora")
    public String hora() {
        return "Hora actual: " + java.time.LocalTime.now();
    }

    // 6. Mini-Trivia
    // Endpoint: GET /varios/trivia
    @GetMapping("/trivia")
    public String trivia() {
        List<String> preguntas = List.of(
                "¿Capital de Francia?",
                "¿2 + 2?",
                "¿Color del cielo?",
                "¿Lenguaje de Spring Boot?"
        );
        Random random = new Random();
        return preguntas.get(random.nextInt(preguntas.size()));
    }
}
