package com.spartans.dev.gym_hub.dto.ficha;

public record FichaRequest(
         String nome,
         String objetivo,
         long usuario_id
) {
}
