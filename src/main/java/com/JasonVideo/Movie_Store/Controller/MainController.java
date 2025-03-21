package com.JasonVideo.Movie_Store.Controller;
import com.JasonVideo.Movie_Store.Model.Movie;
import com.JasonVideo.Movie_Store.Repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    MovieRepo movieRepo;

    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return movieRepo.findAll();
    }
}