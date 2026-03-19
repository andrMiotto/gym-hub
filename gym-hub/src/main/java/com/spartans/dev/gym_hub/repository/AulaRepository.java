package com.spartans.dev.gym_hub.repository;

import com.spartans.dev.gym_hub.model.Aula;
import com.spartans.dev.gym_hub.model.Equipamento;
import com.spartans.dev.gym_hub.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Long> {

    List<Professor> findAllByProfessor(Professor professor);



}
