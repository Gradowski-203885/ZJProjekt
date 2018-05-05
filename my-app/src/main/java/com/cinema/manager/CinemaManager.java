package com.cinema.manager;

import com.cinema.model.Cinema;
import com.cinema.repository.CinemaRepository;
import com.cinema.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaManager implements CinemaService {

    @Autowired
    CinemaRepository cinemaRepository;

    @Override
    public Cinema getCinema(Long id) {
        return cinemaRepository.findOne(id);
    }

    @Override
    public Long updateCinema(Cinema cinema) {
        Cinema toUpdate = cinemaRepository.findOne(cinema.getId());
        toUpdate.setAddress(cinema.getAddress());
        toUpdate.setCity(cinema.getCity());
        toUpdate.setScreeningRooms(cinema.getScreeningRooms());

        return cinemaRepository.save(toUpdate).getId();
    }

    @Override
    public Long addCinema(Cinema cinema) {
        return cinemaRepository.save(cinema).getId();
    }

    @Override
    public void deleteCinema(Long id) {
        cinemaRepository.delete(id);
    }
}
