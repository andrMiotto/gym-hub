package com.spartans.dev.gym_hub.mapper.Ficha;

import com.spartans.dev.gym_hub.dto.ficha.FichaRequest;
import com.spartans.dev.gym_hub.dto.ficha.FichaResponse;
import com.spartans.dev.gym_hub.model.Ficha;
import org.springframework.stereotype.Component;

@Component
public class FichaMapper {


    public Ficha paraEntidade(FichaRequest fichaRequest) {
        return new Ficha(fichaRequest.nome(), fichaRequest.objetivo(), fichaRequest.usuario_id());
    }


    public FichaResponse paraDTO(Ficha ficha) {
        return new FichaResponse(ficha.getId(), ficha.getNome(), ficha.getObjetivo(), ficha.getUsuario_id());
    }

}
