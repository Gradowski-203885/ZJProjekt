package com.cinema.model;


import javax.persistence.*;

@Entity
@Table(name = "Seats")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "rowInTheater")
    private int row;

    @Column(name="numberOfSeat")
    private int number;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "ScreeningRooms_idScreeningRooms")
    private ScreeningRoom screeningRoom;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "Reservations_idReservations")
    private Reservation reservation;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ScreeningRoom getScreeningRoom() {
        return screeningRoom;
    }

    public void setScreeningRoom(ScreeningRoom screeningRoom) {
        this.screeningRoom = screeningRoom;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
