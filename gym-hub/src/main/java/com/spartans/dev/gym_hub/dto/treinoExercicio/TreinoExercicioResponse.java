package com.spartans.dev.gym_hub.dto.treinoExercicio;

public record TreinoExercicioResponse(

        Long id,
        Long treinoId,
        String treinoNome,
        Long exercicioId,
        String exercicioNome,
        int series,
        int repeticoes,
        String descanso

) {}