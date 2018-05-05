package com.cinema.manager;

import com.cinema.model.Seance;
import com.cinema.repository.SeanceRepository;
import com.cinema.service.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeanceManager implements SeanceService {

    @Autowired
    SeanceRepository seanceRepository;

    @Override
    public Seance getSeance(Long id) {
        return seanceRepository.findOne(id);
    }

    @Override
    public Long updateSeance(Seance seance) {
        Seance toUpdate = seanceRepository.findOne(seance.getId());
        toUpdate.setData(seance.getData());
        toUpdate.setMovie(seance.getMovie());
        toUpdate.setScreeningRoom(seance.getScreeningRoom());

        return seanceRepository.save(toUpdate).getId();
    }

    @Override
    public Long addSeance(Seance seance) {
        return seanceRepository.save(seance).getId();
    }

    @Override
    public void deleteSeance(Long id) {
        seanceRepository.delete(id);
    }
}
