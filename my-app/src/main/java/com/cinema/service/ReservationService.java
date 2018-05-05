package com.cinema.service;

import com.cinema.model.Reservation;

public interface ReservationService {
    Reservation getReservation(Long id);
    Long updateReservation(Reservation reservation);
    Long addReservation(Reservation reservation);
    void deleteReservation(Long id);
}
