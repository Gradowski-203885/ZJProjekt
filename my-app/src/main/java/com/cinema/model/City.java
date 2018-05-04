package com.cinema.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "NameOfCity")
    private String name;

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "Cities_idCities")
    private List<Cinema> cinemas = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cinema> getCinemas() {
        return cinemas;
    }

    public void setCinemas(List<Cinema> cinemas) {
        this.cinemas = cinemas;
    }
}
