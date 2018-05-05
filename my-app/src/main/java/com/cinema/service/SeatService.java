package com.cinema.service;

import com.cinema.model.Seat;

public interface SeatService {
    Seat getSeat(Long id);
    Long updateSeat(Seat seat);
    Long addSeat(Seat seat);
    void deleteSeat(Long id);
}
