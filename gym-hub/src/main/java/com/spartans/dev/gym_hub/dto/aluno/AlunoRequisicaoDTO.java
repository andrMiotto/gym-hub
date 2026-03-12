package com.spartans.dev.gym_hub.dto.aluno;

import jakarta.persistence.Column;

import java.sql.Date;

public record AlunoRequisicaoDTO(

        String nome,

        Double altura,

        Double massaCorporal,

        Date nascimento,

        String user,

        String senha,

        Date dataCadastro,

        String imc,

        String cpf


) {
}
