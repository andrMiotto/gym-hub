package com.spartans.dev.gym_hub.controller;

import com.spartans.dev.gym_hub.dto.aula.AulaRequisicaoDTO;
import com.spartans.dev.gym_hub.dto.aula.AulaRespostaDTO;
import com.spartans.dev.gym_hub.dto.professor.ProfessorRequisicaoDTO;
import com.spartans.dev.gym_hub.dto.professor.ProfessorRespostaDTO;
import com.spartans.dev.gym_hub.service.AulaService;
import com.spartans.dev.gym_hub.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/professores")
public class ProfessorController {

    private final ProfessorService professorService;

    @PostMapping("/cadastrar")
    public ProfessorRespostaDTO create(@RequestBody ProfessorRequisicaoDTO professorRequisicaoDTO) {
        return professorService.create(professorRequisicaoDTO);

    }

    @GetMapping("/listarTodos")
    public List<ProfessorRespostaDTO> listAll() {
        return professorService.listAll();

    }


    @GetMapping("/listarId/{id}")
    public ProfessorRespostaDTO listId(@PathVariable("id") Long id) {
        return professorService.findById(id);

    }

    @PutMapping("/atualizar/{id}")
    public ProfessorRespostaDTO update(@PathVariable("id")long id, @RequestBody ProfessorRequisicaoDTO professorRequisicaoDTO) {
        return professorService.update(id,professorRequisicaoDTO);

    }


    @DeleteMapping("/deletar/{id}")
    public void delete(@PathVariable("id")Long id){
        professorService.delete(id);
    }


}
