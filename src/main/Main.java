package main;

import main.model.movie.Movie;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Movie movie = new Movie("Flatliners", 115, false, "R", 1992);
        System.out.println(movie);
    }
}