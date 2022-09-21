package main.model.movie;

import main.model.movie.impl.Discount;

public class DVD extends Movie implements Discount {

    public DVD(String name, double cost, double runTime, boolean starsNickCage, String rating, int yearOfRelease) {
        super(name, cost, runTime, starsNickCage, rating, yearOfRelease);
        discount();
    }

    @Override
    public void discount() {
        final double MOVIE_DISCOUNT = .10;
        setCost(this, getCost() * MOVIE_DISCOUNT);
    }
}
