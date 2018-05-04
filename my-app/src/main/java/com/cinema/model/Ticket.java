package com.cinema.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "Users_idUsers")
    private User user;

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY,orphanRemoval=true)
    @JoinColumn(name = "Tickets_idTickets" )
    private List<Reservation> reservations;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
