package com.cinema.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="Title")
    private String title;

    @Column(name="Actors")
    private String actor;

    @Column(name="Director")
    private String director;

    @Column(name = "PremiereDate")
    private String premiere;

    @Column(name = "Duration")
     private String duration;

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "Movies_idMovies")
   private List<Seance> seances = new ArrayList<>();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPremiere() {
        return premiere;
    }

    public void setPremiere(String premiere) {
        this.premiere = premiere;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public List<Seance> getSeances() {
        return seances;
    }

    public void setSeances(List<Seance> seances) {
        this.seances = seances;
    }
}
