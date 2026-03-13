package com.spartans.dev.gym_hub.dto.aula;

public record AulaResponse (
        long id,
        String nome,
        String descricao,
        String duracao
){
}
