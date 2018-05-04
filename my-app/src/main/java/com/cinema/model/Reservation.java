package com.cinema.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.LAZY)
    @JoinColumn(name = "Tickets_IdTickets")
    private Ticket ticket;

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, orphanRemoval=true)
    @JoinColumn(name = "Reservations_idReservations")
    private List<Seat> seats;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
