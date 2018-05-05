package com.cinema.service;

import com.cinema.model.Cinema;

public interface CinemaService {
    Cinema getCinema(Long id);
    Long updateCinema(Cinema cinema);
    Long addCinema(Cinema cinema);
    void deleteCinema(Long id);
}
