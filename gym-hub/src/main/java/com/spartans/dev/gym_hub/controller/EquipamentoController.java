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

    @PostMapping("/register")
    public EquipamentoResponse create(EquipamentoRequest equipamentoRequest){
        try{
            return equipamentoService.create(equipamentoRequest);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/list")
    public List<EquipamentoResponse> list (){
        try{
            return equipamentoService.listAll();
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/list/{id}")
    public EquipamentoResponse listById(@PathVariable long id){
        try{
            return equipamentoService.findById(id);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("update/{id}")
    public EquipamentoResponse update(@PathVariable long id, EquipamentoRequest equipamentoRequest){
        try{
            return equipamentoService.update(id, equipamentoRequest);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete (@PathVariable long id){
        try{
            equipamentoService.delete(id);
            return ResponseEntity.status(201).body("O equipamento foi deletado");
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
