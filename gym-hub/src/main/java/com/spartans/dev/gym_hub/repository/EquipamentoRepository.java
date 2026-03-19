package com.spartans.dev.gym_hub.repository;

import com.spartans.dev.gym_hub.model.Equipamento;
import com.spartans.dev.gym_hub.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {


    List<Equipamento> findAllByAnatomia(String anatomia);


}
