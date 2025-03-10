package com.JasonVideo.Movie_Store.Controller;
import com.JasonVideo.Movie_Store.Repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Autowired
    MovieRepo movieRepo;

    @PostMapping("/movies")
    public void getMovies() {
        movieRepo.findAll();
    }
}