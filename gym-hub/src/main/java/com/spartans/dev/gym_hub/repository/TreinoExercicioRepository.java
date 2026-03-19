package com.spartans.dev.gym_hub.repository;


import com.spartans.dev.gym_hub.model.TreinoExercicio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TreinoExercicioRepository extends JpaRepository<TreinoExercicio, Long> {

    List<TreinoExercicio> findByTreinoId(Long treinoId);

    boolean existsByTreinoIdAndExercicioId(Long treinoId, Long exercicioId);
}
