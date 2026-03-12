package com.spartans.dev.gym_hub.dto.professor;

import jakarta.persistence.Column;

public record ProfessorRequisicaoDTO(
         String nome,

         String cref,

         String especialidade,

         String sobre,

         Double avaliacao,

         String cpf


) {
}
