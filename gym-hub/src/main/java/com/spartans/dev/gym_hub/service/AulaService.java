package com.spartans.dev.gym_hub.service;

import com.spartans.dev.gym_hub.dto.aula.AulaRequisicaoDTO;
import com.spartans.dev.gym_hub.dto.aula.AulaRespostaDTO;
import com.spartans.dev.gym_hub.mapper.AulaMapper;
import com.spartans.dev.gym_hub.model.Aula;
import com.spartans.dev.gym_hub.repository.AulaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AulaService {

    private final AulaRepository aulaRepository;
    private final AulaMapper aulaMapper;


    public AulaRespostaDTO create(AulaRequisicaoDTO aulaRequisicaoDTO) {

        Aula aula = aulaMapper.paraEntidade(aulaRequisicaoDTO);

        if (aula.getId() != null && aulaRepository.existsById(aula.getId())) {
            throw new RuntimeException("Aula ja existente");
        }

        Aula aulaSalvo = aulaRepository.save(aula);

        return aulaMapper.paraRespostaDTO(aulaSalvo);
    }


    public List<AulaRespostaDTO> listAll() {

        List<Aula> aulas = aulaRepository.findAll();

        return aulas.stream()
                .map(aula -> {
                    return aulaMapper.paraRespostaDTO(aula);

                })

                .toList();

    }

    public AulaRespostaDTO findById(long id) {
        Aula aula = aulaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aula não existe!"));

        return aulaMapper.paraRespostaDTO(aula);
    }


    public AulaRespostaDTO update(Long id, AulaRequisicaoDTO aula) {
        Aula aulaExistente = aulaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aula nao existe"));

        aulaExistente.setNome(aula.nome());
        aulaExistente.setDescricao(aula.descricao());
        aulaExistente.setDuracao(aula.duracao());

        Aula aulaAtualizada = aulaRepository.save(aulaExistente);
        return aulaMapper.paraRespostaDTO(aulaAtualizada);

    }


    public void delete(Long id) {
        if (!aulaRepository.existsById(id)) {
            throw new RuntimeException("Aula nao existe");
        }

        aulaRepository.deleteById(id);
    }


}



