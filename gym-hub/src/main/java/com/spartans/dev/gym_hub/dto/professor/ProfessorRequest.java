package com.spartans.dev.gym_hub.dto.professor;

public record ProfessorRequest (
        String nome,
        String cref,
        String especialidade,
        String sobre,
        double avaliacao,
        String cpf
){

}
