package com.spartans.dev.gym_hub.dto.ficha;

public record FichaResponse(
        long id,
        String nome,
        String objetivo,
        long usuario_id

) {
}
