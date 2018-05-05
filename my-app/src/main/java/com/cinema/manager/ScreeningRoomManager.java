package com.cinema.manager;

import com.cinema.model.ScreeningRoom;
import com.cinema.repository.ScreeningRoomRepository;
import com.cinema.service.ScreeningRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScreeningRoomManager implements ScreeningRoomService {

    @Autowired
    ScreeningRoomRepository screeningRoomRepository;

    @Override
    public ScreeningRoom getScreeningRoom(Long id) {
        return screeningRoomRepository.findOne(id);
    }

    @Override
    public Long updateScreeningRoom(ScreeningRoom screeningRoom) {
        ScreeningRoom toUpdate = screeningRoomRepository.findOne(screeningRoom.getId());
        toUpdate.setCinema(screeningRoom.getCinema());
        toUpdate.setNumber(screeningRoom.getNumber());
        toUpdate.setSeances(screeningRoom.getSeances());
        toUpdate.setSeats(screeningRoom.getSeats());
        toUpdate.setSponsorName(screeningRoom.getSponsorName());

        return screeningRoomRepository.save(toUpdate).getId();
    }

    @Override
    public Long addScreeningRoom(ScreeningRoom screeningRoom) {
        return screeningRoomRepository.save(screeningRoom).getId();
    }

    @Override
    public void deleteScreeningRoom(Long id) {
        screeningRoomRepository.delete(id);
    }
}
