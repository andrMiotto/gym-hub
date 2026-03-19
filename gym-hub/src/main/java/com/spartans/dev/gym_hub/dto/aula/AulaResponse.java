package com.spartans.dev.gym_hub.dto.aula;

import com.spartans.dev.gym_hub.model.Professor;

public record AulaResponse(
        long id,
        String nome,
        String descricao,
        String duracao,
        Professor professor

) {
}
