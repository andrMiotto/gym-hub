package com.spartans.dev.gym_hub.repository;

import com.spartans.dev.gym_hub.model.Aula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AulaRepository extends JpaRepository<Aula,Long> {


}
