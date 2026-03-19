package com.spartans.dev.gym_hub.repository;

import com.spartans.dev.gym_hub.model.Ficha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface FichaRepository extends JpaRepository<Ficha, Long> {
}
