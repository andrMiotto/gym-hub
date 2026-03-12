package com.spartans.dev.gym_hub.service;

import com.spartans.dev.gym_hub.dto.aula.AulaRequisicaoDTO;
import com.spartans.dev.gym_hub.dto.aula.AulaRespostaDTO;
import com.spartans.dev.gym_hub.dto.professor.ProfessorRequisicaoDTO;
import com.spartans.dev.gym_hub.dto.professor.ProfessorRespostaDTO;
import com.spartans.dev.gym_hub.mapper.AulaMapper;
import com.spartans.dev.gym_hub.mapper.ProfessorMapper;
import com.spartans.dev.gym_hub.model.Aula;
import com.spartans.dev.gym_hub.model.Professor;
import com.spartans.dev.gym_hub.repository.AulaRepository;
import com.spartans.dev.gym_hub.repository.ProfessorRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final ProfessorMapper professorMapper;


    public ProfessorRespostaDTO create(ProfessorRequisicaoDTO professorRequisicaoDTO) {

        Professor professor = professorMapper.paraEntidade(professorRequisicaoDTO);

        if (professor.getId() != null && professorRepository.existsById(professor.getId())) {
            throw new RuntimeException("Professor ja existente");
        }

        Professor professorSalvo = professorRepository.save(professor);

        return professorMapper.paraRespostaDTO(professorSalvo);
    }


    public List<ProfessorRespostaDTO> listAll() {

        List<Professor> professores = professorRepository.findAll();

        return professores.stream()
                .map(professor -> {
                    return professorMapper.paraRespostaDTO(professor);

                })

                .toList();

    }

    public ProfessorRespostaDTO findById(long id) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não existe!"));

        return professorMapper.paraRespostaDTO(professor);
    }


    public ProfessorRespostaDTO update(Long id, ProfessorRequisicaoDTO professorRequisicaoDTO) {
        Professor professorExistente = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor nao existe"));

        professorExistente.setNome(professorRequisicaoDTO.nome());
        professorExistente.setCref(professorRequisicaoDTO.cref());
        professorExistente.setEspecialidade(professorRequisicaoDTO.especialidade());
        professorExistente.setSobre(professorRequisicaoDTO.sobre());
        professorExistente.setAvaliacao(professorRequisicaoDTO.avaliacao());
        professorExistente.setCpf(professorRequisicaoDTO.cpf());


        Professor professorAtualizado = professorRepository.save(professorExistente);
        return professorMapper.paraRespostaDTO(professorAtualizado);

    }


    public void delete(Long id) {
        if (!professorRepository.existsById(id)) {
            throw new RuntimeException("Professor nao existe");
        }

        professorRepository.deleteById(id);
    }


}
