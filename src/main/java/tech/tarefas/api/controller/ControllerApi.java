package tech.tarefas.api.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.tarefas.api.modelo.Tarefa;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ControllerApi  {

    private List<String> tarefas = new ArrayList<>();


    @GetMapping(path = "/lista-tarefas")
    public ResponseEntity<List<String>> getTarefas() {
        return ResponseEntity.ok(tarefas);
    }

    @PostMapping(path = "/tarefas")
    public ResponseEntity<Void> postTarefas(@RequestBody Tarefa tarefa){
        tarefas.add(String.valueOf(tarefa));
        return ResponseEntity.created(URI.create("http://localhost:8080/tarefas")).build();
    }

    @DeleteMapping(path = "/deleta-tarefas")
    public ResponseEntity<List<String>> deleteTarefas(@RequestBody Tarefa tarefa) {
        tarefas.removeIf(t -> tarefa.getNome().equalsIgnoreCase(tarefa.getNome()));
        return ResponseEntity.ok(tarefas);
    }

}
