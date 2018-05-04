package com.cinema.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Seances")
public class Seance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "DataOfSeance")
    private LocalDateTime data;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "ScreeningRooms_idScreeningRooms")
    private ScreeningRoom screeningRoom;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "Movies_idMovies")
    private Movie movie;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public ScreeningRoom getScreeningRoom() {
        return screeningRoom;
    }

    public void setScreeningRoom(ScreeningRoom screeningRoom) {
        this.screeningRoom = screeningRoom;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
