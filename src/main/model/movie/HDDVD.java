package main.model.movie;

import main.model.movie.impl.Discount;

public class HDDVD extends Movie implements Discount {
    public HDDVD(String name, double cost, double runTime, boolean starsNickCage, String rating, int yearOfRelease) {
        super(name, cost, runTime, starsNickCage, rating, yearOfRelease);
    }

    @Override
    public void discount() {
        final double DISCOUNT = .50;
        setCost(this, getCost() * DISCOUNT);
    }
}
