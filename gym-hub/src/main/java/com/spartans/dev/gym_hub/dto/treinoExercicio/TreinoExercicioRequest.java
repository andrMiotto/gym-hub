package com.spartans.dev.gym_hub.dto.treinoExercicio;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record TreinoExercicioRequest(

        @NotNull(message = "O treino é obrigatório")
        Long treinoId,

        @NotNull(message = "O exercício é obrigatório")
        Long exercicioId,

        @Positive
        @Min(value = 1, message = "O mínimo de séries é 1")
        int series,

        @Positive
        @Min(value = 1, message = "O mínimo de repetições é 1")
        int repeticoes,

        @NotBlank(message = "O tempo de descanso é obrigatório")
        String descanso

) {}