package com.cinema.repository;

import com.cinema.model.Seance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeanceRepository extends JpaRepository<Seance, Long> {
}
