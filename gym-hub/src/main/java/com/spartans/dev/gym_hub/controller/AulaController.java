package com.spartans.dev.gym_hub.controller;

import com.spartans.dev.gym_hub.dto.aula.AulaRequest;
import com.spartans.dev.gym_hub.dto.aula.AulaResponse;
import com.spartans.dev.gym_hub.service.AulaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aulas")
@RequiredArgsConstructor
public class AulaController {

    private final AulaService aulaService;

    @PostMapping("/cadastrar")
    public AulaResponse criarAula(@RequestBody AulaRequest aulaRequest){
        try{
            return aulaService.criarAula(aulaRequest);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/listar")
    public List<AulaResponse> listarAulas (){
        try{
            return aulaService.listarAulas();
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/listar/{id}")
    public AulaResponse listarAulaPorId(@PathVariable long id){
        try {
            return aulaService.listarAulaPorId(id);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/atualizar/{id}")
    public AulaResponse atualizarAula(@PathVariable long id, @RequestBody AulaRequest aulaRequest){
        try{
            return aulaService.atualizarAula(id, aulaRequest);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarPorId(@PathVariable long id){
        try{
            aulaService.deletarAula(id);
            return ResponseEntity.status(201).body("A aula foi deletada");
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
