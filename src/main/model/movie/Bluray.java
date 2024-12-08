package main.model.movie;

public class Bluray extends Movie{

    public Bluray(String name, double cost, double runTime, boolean starsNickCage, String rating, int yearOfRelease) {
        super(name, cost, runTime, starsNickCage, rating, yearOfRelease);
    }

    public Bluray(Movie movie) {
        super(movie);
    }
}
