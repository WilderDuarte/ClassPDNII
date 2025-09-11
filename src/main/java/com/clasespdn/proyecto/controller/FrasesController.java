package com.clasespdn.proyecto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class FrasesController {

    private String[] frases = {
            "El conocimiento es poder 📚",
            "Spring Boot es divertido 🚀",
            "La práctica hace al maestro 💡",
            "El código es poesía 💻"
    };

    @GetMapping("/frase")
    public String fraseAleatoria() {
        Random random = new Random();
        int index = random.nextInt(frases.length);
        return frases[index];
    }
}
