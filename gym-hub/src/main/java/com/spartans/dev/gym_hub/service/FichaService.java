package com.spartans.dev.gym_hub.service;

import com.spartans.dev.gym_hub.dto.ficha.FichaRequest;
import com.spartans.dev.gym_hub.dto.ficha.FichaResponse;
import com.spartans.dev.gym_hub.mapper.Ficha.FichaMapper;
import com.spartans.dev.gym_hub.model.Ficha;
import com.spartans.dev.gym_hub.repository.FichaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FichaService {


    private final FichaRepository fichaRepository;
    private final FichaMapper fichaMapper;


    public FichaResponse create(FichaRequest fichaRequest) {

        Ficha ficha = fichaMapper.paraEntidade(fichaRequest);

        Ficha fichaSalva = fichaRepository.save(ficha);
        FichaResponse fichaResponse = fichaMapper.paraDTO(fichaSalva);

        return fichaResponse;
    }

    public List<FichaResponse> listAll() {
        if (fichaRepository.findAll().isEmpty()) {
            throw new RuntimeException("Não existe nenhuma ficha cadastrada");
        }
        List<Ficha> fichas = fichaRepository.findAll();
        List<FichaResponse> dto = new ArrayList<>();

        for (Ficha ficha : fichas) {
            dto.add(fichaMapper.paraDTO(ficha));
        }

        return dto;
    }

    public FichaResponse findById(long id) {

        Ficha ficha = fichaRepository.findById(id).orElseThrow(() -> new RuntimeException("Esta ficha não existe"));
        FichaResponse fichaResponse = fichaMapper.paraDTO(ficha);

        return fichaResponse;
    }

    public FichaResponse update(long id, FichaRequest fichaRequest) {

        Ficha ficha = fichaRepository.findById(id).orElseThrow(() -> new RuntimeException("Não existe ficha com este id"));
        ficha.setNome(fichaRequest.nome());
        ficha.setObjetivo(fichaRequest.objetivo());
        ficha.setUsuario_id(fichaRequest.usuario_id());


        Ficha fichaSalva = fichaRepository.save(ficha);
        FichaResponse fichaResponse = fichaMapper.paraDTO(fichaSalva);
        return fichaResponse;
    }

    public void delete(long id) {
        if (fichaRepository.existsById(id)) {
            fichaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Erro ao deletar, não existe ficha com este ID");
        }
    }

}
