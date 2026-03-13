package com.spartans.dev.gym_hub.service;

import com.spartans.dev.gym_hub.dto.equipamento.EquipamentoRequisicaoDTO;
import com.spartans.dev.gym_hub.dto.equipamento.EquipamentoRespostaDTO;
import com.spartans.dev.gym_hub.mapper.EquipamentoMapper;
import com.spartans.dev.gym_hub.model.Equipamento;
import com.spartans.dev.gym_hub.repository.EquipamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipamentoService {

    private final EquipamentoRepository equipamentoRepository;
    private final EquipamentoMapper equipamentoMapper;

    public EquipamentoRespostaDTO criarEquipamento(EquipamentoRequisicaoDTO equipamentoRequest) {
        Equipamento equipamento = equipamentoMapper.paraEntidade(equipamentoRequest);
        EquipamentoRespostaDTO equipamentoResponse = equipamentoMapper.paraDTO(equipamento);

        return equipamentoResponse;
    }

    public List<EquipamentoRespostaDTO> listarEquipamentos() {
        List<Equipamento> equipamentos = equipamentoRepository.findAll();
        List<EquipamentoRespostaDTO> dto = new ArrayList<>();

        for (Equipamento equipamento : equipamentos) {
            dto.add(equipamentoMapper.paraDTO(equipamento));
        }
        return dto;
    }

    public EquipamentoRespostaDTO listarPorId(long id) {

        Equipamento equipamento = equipamentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Não existe um equipamento com este id"));
        EquipamentoRespostaDTO equipamentoResponse = equipamentoMapper.paraDTO(equipamento);

        return equipamentoResponse;
    }

    public EquipamentoRespostaDTO atualizar(long id, EquipamentoRespostaDTO equipamentoRequest) {

        Equipamento equipamento = equipamentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Não existe usuário com este id"));
        equipamento.setNome(equipamentoRequest.nome());
        equipamento.setDescricao(equipamentoRequest.descricao());
        equipamento.setAnatomia(equipamentoRequest.anatomia());

        Equipamento equipamentoSalvo = equipamentoRepository.save(equipamento);
        EquipamentoRespostaDTO equipamentoResponse = equipamentoMapper.paraDTO(equipamentoSalvo);
        return equipamentoResponse;
    }

    public void deletarEquipamento(long id) {
        equipamentoRepository.deleteById(id);
    }

}

