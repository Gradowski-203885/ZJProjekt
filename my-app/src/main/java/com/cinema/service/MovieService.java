package com.cinema.service;

import com.cinema.model.Movie;

public interface MovieService {
    Movie getMovie(Long id);
    Long updateMovie(Movie movie);
    Long addMovie(Movie movie);
    void deleteMovie(Long id);
}
