package com.spartans.dev.gym_hub.repository;

import com.spartans.dev.gym_hub.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
