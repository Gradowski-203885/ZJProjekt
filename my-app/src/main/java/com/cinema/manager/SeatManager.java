package com.cinema.manager;

import com.cinema.model.Seat;
import com.cinema.repository.SeatRepository;
import com.cinema.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatManager implements SeatService {

    @Autowired
    SeatRepository seatRepository;

    @Override
    public Seat getSeat(Long id) {
        return seatRepository.findOne(id);
    }

    @Override
    public Long updateSeat(Seat seat) {
        Seat toUpdate = seatRepository.findOne(seat.getId());
        toUpdate.setNumber(seat.getNumber());
        toUpdate.setReservation(seat.getReservation());
        toUpdate.setRow(seat.getRow());
        toUpdate.setScreeningRoom(seat.getScreeningRoom());

        return seatRepository.save(toUpdate).getId();
    }

    @Override
    public Long addSeat(Seat seat) {
        return seatRepository.save(seat).getId();
    }

    @Override
    public void deleteSeat(Long id) {
        seatRepository.delete(id);
    }
}
