package com.clasespdn.proyecto.controller.playground;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/ejemplo/tareas")
public class EjmController {

    private List<String> tareas = new ArrayList<>(List.of("Estudiar", "Practicar Spring"));

    // GET - Listar todas las tareas
    // Endpoint: GET /ejemplo/tareas
    @GetMapping
    public List<String> getTareas() {
        return tareas;
    }

    // POST - Agregar nueva tarea
    // Endpoint: POST /ejemplo/tareas?tarea=AprenderGit
    @PostMapping
    public String addTarea(@RequestParam String tarea) {
        tareas.add(tarea);
        return "Tarea agregada: " + tarea;
    }

    // PUT - Actualizar una tarea existente
    // Endpoint: PUT /ejemplo/tareas/0?nueva=Ir al gimnasio
    @PutMapping("/{index}")
    public String updateTarea(@PathVariable int index, @RequestParam String nueva) {
        tareas.set(index, nueva);
        return "Tarea actualizada en " + index + ": " + nueva;
    }

    // DELETE - Eliminar una tarea
    // Endpoint: DELETE /ejemplo/tareas/1
    @DeleteMapping("/{index}")
    public String deleteTarea(@PathVariable int index) {
        String eliminada = tareas.remove(index);
        return "Tarea eliminada: " + eliminada;
    }
}
