package com.cinema.manager;

import com.cinema.model.Movie;
import com.cinema.repository.MovieRepository;
import com.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieManager implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public Movie getMovie(Long id) {
        return movieRepository.findOne(id);
    }

    @Override
    public Long updateMovie(Movie movie) {
        Movie toUpdate = movieRepository.findOne(movie.getId());
        toUpdate.setActor(movie.getActor());
        toUpdate.setDirector(movie.getDirector());
        toUpdate.setDuration(movie.getDuration());
        toUpdate.setPremiere(movie.getPremiere());
        toUpdate.setSeances(movie.getSeances());
        toUpdate.setTitle(movie.getTitle());

        return movieRepository.save(toUpdate).getId();
    }

    @Override
    public Long addMovie(Movie movie) {
        return movieRepository.save(movie).getId();
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.delete(id);
    }
}
