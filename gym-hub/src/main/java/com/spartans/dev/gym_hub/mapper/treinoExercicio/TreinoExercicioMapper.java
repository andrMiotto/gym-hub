package com.spartans.dev.gym_hub.mapper.treinoExercicio;

import com.spartans.dev.gym_hub.dto.treinoExercicio.TreinoExercicioRequest;
import com.spartans.dev.gym_hub.dto.treinoExercicio.TreinoExercicioResponse;
import com.spartans.dev.gym_hub.model.Exercicio;
import com.spartans.dev.gym_hub.model.Treino;
import com.spartans.dev.gym_hub.model.TreinoExercicio;
import org.springframework.stereotype.Component;

@Component
public class TreinoExercicioMapper {

    public TreinoExercicio paraEntidade(TreinoExercicioRequest request, Treino treino, Exercicio exercicio) {
        return new TreinoExercicio(treino, exercicio, request.series(), request.repeticoes(), request.descanso());
    }

    public TreinoExercicioResponse paraDTO(TreinoExercicio treinoExercicio) {
        return new TreinoExercicioResponse(
                treinoExercicio.getId(),
                treinoExercicio.getTreino().getId(),
                treinoExercicio.getTreino().getNome(),
                treinoExercicio.getExercicio().getId(),
                treinoExercicio.getExercicio().getNome(),
                treinoExercicio.getSeries(),
                treinoExercicio.getRepeticoes(),
                treinoExercicio.getDescanso()
        );
    }
}
