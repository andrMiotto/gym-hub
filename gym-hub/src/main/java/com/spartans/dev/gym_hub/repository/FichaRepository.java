package com.spartans.dev.gym_hub.repository;

import com.spartans.dev.gym_hub.model.Equipamento;
import com.spartans.dev.gym_hub.model.Ficha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface FichaRepository extends JpaRepository<Ficha, Long> {
    List<Ficha> findAllByObjetivo(String objetivo);

}
