package com.spartans.dev.gym_hub.controller;

import com.spartans.dev.gym_hub.dto.aula.AulaRequest;
import com.spartans.dev.gym_hub.dto.aula.AulaResponse;
import com.spartans.dev.gym_hub.service.AulaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/class")
public class AulaController {

    private final AulaService aulaService;

    @PostMapping("/register")
    public AulaResponse create(@RequestBody AulaRequest aula) {
        return aulaService.create(aula);

    }

    @GetMapping("/list")
    public List<AulaResponse> listAll() {
        return aulaService.listAll();

    }


    @GetMapping("/list/{id}")
    public AulaResponse listId(@PathVariable("id") Long id) {
        return aulaService.findById(id);

    }

    @PutMapping("/update/{id}")
    public AulaResponse update(@PathVariable("id")long id, @RequestBody AulaRequest aulaRequisicaoDTO) {
        return aulaService.update(id,aulaRequisicaoDTO);

    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id")Long id){
        aulaService.delete(id);
    }


}
