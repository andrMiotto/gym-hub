package com.spartans.dev.gym_hub.dto.aula;

import com.spartans.dev.gym_hub.model.Professor;

public record AulaRequest(
        String nome,
        String descricao,
        String duracao,
        Professor professor
) {
}
