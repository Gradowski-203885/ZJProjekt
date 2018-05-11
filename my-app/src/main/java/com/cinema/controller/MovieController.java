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
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MovieController {

    @Autowired
    MovieService movieService;

    @RequestMapping(value = "/movie", method = RequestMethod.GET, params = {"id"})
    public String showMovieDetails(Model model, HttpServletRequest request, @RequestParam(name = "id") String id) throws CloneNotSupportedException{
        Movie movie = movieService.getMovie(Long.parseLong(id));
        model.addAttribute(movie);
        return "movie";
    }

}
