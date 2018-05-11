package com.cinema.controller;


import com.cinema.model.Movie;
import com.cinema.repository.MovieRepository;
import com.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MovieController {

    @Autowired
    MovieService movieService;

    @RequestMapping(value = "/movie/{id}", method = RequestMethod.GET)
    public String showMovieDetails(Model model, HttpServletRequest request, @PathVariable Long id) throws CloneNotSupportedException{
        Movie movie = movieService.getMovie(id);
        model.addAttribute(movie);
        return "movie";
    }

}
