package com.spartans.dev.gym_hub.repository;

import com.spartans.dev.gym_hub.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    Optional<Professor> findByCref(String cref);
    Boolean existsByCpf(String cpf);
    List<Professor> findAllByEspecialidade(String especialidade);

}
