package com.cinema.manager;

import com.cinema.model.Reservation;
import com.cinema.repository.ReservationRepository;
import com.cinema.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationManager implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public Reservation getReservation(Long id) {
        return reservationRepository.findOne(id);
    }

    @Override
    public Long updateReservation(Reservation reservation) {
        Reservation toUpdate = reservationRepository.findOne(reservation.getId());
        toUpdate.setSeats(reservation.getSeats());
        toUpdate.setTicket(reservation.getTicket());

        return reservationRepository.save(toUpdate).getId();
    }

    @Override
    public Long addReservation(Reservation reservation) {
        return reservationRepository.save(reservation).getId();
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepository.delete(id);
    }
}
