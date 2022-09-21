package main;

import main.model.movie.DVD;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        DVD movie = new DVD("Flatliners", 99.99, 120, false, "R", 1990);
        System.out.println(movie);
        System.out.println(movie.getName());
        System.out.println(movie.getCost());
        System.out.println(movie.getRunTime());
        System.out.println(movie.getStarsNickCage());
        System.out.println(movie.getRating());
        System.out.println(movie.getYearOfRelease());
        System.out.println();
        movie.setName("Jason");
        movie.setCost(movie, 50);
        movie.setRunTime(999);
        movie.setStarsNickCage(true);
        movie.setRating("PG13");
        movie.setYearOfRelease(1987);
        System.out.println(movie);
        System.out.println(movie.getName());
        System.out.println(movie.getCost());
        System.out.println(movie.getRunTime());
        System.out.println(movie.getStarsNickCage());
        System.out.println(movie.getRating());
        System.out.println(movie.getYearOfRelease());
    }
}