package com.cinema.controller;

import com.cinema.model.Movie;
import com.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    MovieService movieService;

    @RequestMapping(value = "/main",method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request){

        List<Movie> movies = new ArrayList<>();
        //TODO: add parameter airing and get those? Matter to discuss
        for(int i=1;i<=2;i++)
        movies.add(movieService.getMovie((long)i));
        model.addAttribute("movies",movies);
        request.getSession().setAttribute("movies", movies);
        return "main";
    }
}
