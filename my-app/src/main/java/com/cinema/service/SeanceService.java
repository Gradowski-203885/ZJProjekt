package com.cinema.service;

import com.cinema.model.Seance;

public interface SeanceService {
    Seance getSeance(Long id);
    Long updateSeance(Seance seance);
    Long addSeance(Seance seance);
    void deleteSeance(Long id);
}
