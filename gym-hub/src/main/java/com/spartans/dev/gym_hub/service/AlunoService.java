package com.spartans.dev.gym_hub.service;

import com.spartans.dev.gym_hub.dto.aluno.AlunoRequisicaoDTO;
import com.spartans.dev.gym_hub.dto.aluno.AlunoRespostaDTO;
import com.spartans.dev.gym_hub.mapper.AlunoMapper;
import com.spartans.dev.gym_hub.model.Aluno;
import com.spartans.dev.gym_hub.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final AlunoMapper alunoMapper;


    public AlunoRespostaDTO create(AlunoRequisicaoDTO alunoRequisicaoDTO) {

        Aluno aluno = alunoMapper.paraEntidade(alunoRequisicaoDTO);

        if (aluno.getId() != null && alunoRepository.existsById(aluno.getId())) {
            throw new RuntimeException("Aula ja existente");
        }

        Aluno alunoSalvo = alunoRepository.save(aluno);

        return alunoMapper.paraRespostaDTO(alunoSalvo);
    }


    public List<AlunoRespostaDTO> listAll() {

        List<Aluno> alunos = alunoRepository.findAll();

        return alunos.stream()
                .map(aluno -> {
                    return alunoMapper.paraRespostaDTO(aluno);

                })

                .toList();

    }

    public AlunoRespostaDTO findById(long id) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não existe!"));

        return alunoMapper.paraRespostaDTO(aluno);
    }


    public AlunoRespostaDTO update(Long id, AlunoRequisicaoDTO aluno) {
        Aluno alunoExistente = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno nao existe"));

        alunoExistente.setNome(aluno.nome());
        alunoExistente.setAltura(aluno.altura());
        alunoExistente.setMassaCorporal(aluno.massaCorporal());
        alunoExistente.setNascimento(aluno.nascimento());
        alunoExistente.setUser(aluno.user());
        alunoExistente.setSenha(aluno.senha());
        alunoExistente.setDataCadastro(aluno.dataCadastro());
        alunoExistente.setImc(aluno.imc());
        alunoExistente.setCpf(aluno.cpf());


        Aluno alunoAtualizado = alunoRepository.save(alunoExistente);
        return alunoMapper.paraRespostaDTO(alunoAtualizado);

    }


    public void delete(Long id) {
        if (!alunoRepository.existsById(id)) {
            throw new RuntimeException("Aula nao existe");
        }

        alunoRepository.deleteById(id);
    }


}
