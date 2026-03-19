package com.spartans.dev.gym_hub.repository;

import com.spartans.dev.gym_hub.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
