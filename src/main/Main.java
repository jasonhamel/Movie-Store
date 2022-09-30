package main;

import main.model.movie.HDDVD;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        HDDVD movie = new HDDVD("Flatliners", 99.99, 120, false, "R", 1990);
        System.out.println(movie);
        System.out.println(movie.getName());
        System.out.println(movie.getCost());
        System.out.println(movie.getRunTime());
        System.out.println(movie.getStarsNickCage());
        System.out.println(movie.getRating());
        System.out.println(movie.getYearOfRelease());
        System.out.println();
        movie.setName("Jason");
        movie.setStarsNickCage(true);
        movie.updateCost(50);
        movie.setRunTime(999);
        movie.setRating("PG13");
        movie.setYearOfRelease(1987);
        System.out.println(movie);
        System.out.println(movie.getName());
        System.out.println(movie.getCost());
        System.out.println(movie.getRunTime());
        System.out.println(movie.getStarsNickCage());
        System.out.println(movie.getRating());
        System.out.println(movie.getYearOfRelease());
        Store.getInstance().changeStock("Die Hard", 7);
        Store.getInstance().changeStock("Die Hard 2", 10);
        Store.getInstance().changeStock("Die Hard", 1);
    }
}