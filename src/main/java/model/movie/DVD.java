package model.movie;

public class DVD extends Movie {

    public DVD(String name, double cost, double runTime, boolean starsNickCage, String rating, int yearOfRelease) {
        super(name, cost, runTime, starsNickCage, rating, yearOfRelease);
    }
    public DVD (Movie movie) {
        super(movie);
    }
}
