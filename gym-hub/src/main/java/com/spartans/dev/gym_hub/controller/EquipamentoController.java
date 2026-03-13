package com.spartans.dev.gym_hub.controller;

import com.spartans.dev.gym_hub.dto.equipamento.EquipamentoRequest;
import com.spartans.dev.gym_hub.dto.equipamento.EquipamentoResponse;
import com.spartans.dev.gym_hub.service.EquipamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipamentos")
@RequiredArgsConstructor
public class EquipamentoController {

    private final EquipamentoService equipamentoService;

    @PostMapping("/cadastrar")
    public EquipamentoResponse criarEquipamento(EquipamentoRequest equipamentoRequest){
        try{
            return equipamentoService.criarEquipamento(equipamentoRequest);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/listar")
    public List<EquipamentoResponse> listarEquipamentos (){
        try{
            return equipamentoService.listarEquipamentos();
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/listar/{id}")
    public EquipamentoResponse listarEquipamentoPorId(@PathVariable long id){
        try{
            return equipamentoService.listarPorId(id);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("atualizar/{id}")
    public EquipamentoResponse atualizarEquipamento(@PathVariable long id, EquipamentoRequest equipamentoRequest){
        try{
            return equipamentoService.atualizar(id, equipamentoRequest);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarEquipamento (@PathVariable long id){
        try{
            equipamentoService.deletarEquipamento(id);
            return ResponseEntity.status(201).body("O equipamento foi deletado");
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
