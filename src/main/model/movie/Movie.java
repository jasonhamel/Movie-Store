package main.model.movie;


public abstract class Movie {
    private String name;
    private double cost;
    private double runTime;
    private boolean starsNickCage;
    private String rating;
    private int yearOfRelease;

    public Movie(String name, double cost, double runTime, boolean starsNickCage, String rating, int yearOfRelease) {
        this. name = name;
        this.cost = cost;
        this.runTime = runTime;
        this.starsNickCage = starsNickCage;
        this.rating = rating;
        this.yearOfRelease = yearOfRelease;
    }

    public Movie(Movie source) {
        this.name = source.name;
        this.cost = source.cost;
        this.runTime = source.runTime;
        this.starsNickCage = source.starsNickCage;
        this.rating = source.rating;
        this.yearOfRelease = source.yearOfRelease;
    }

    @Override
    public String toString() {
        return "Movie Name: " + this.name + "\n" +
                "Movie Cost: $" + this.cost + "\n" +
                "Runtime in Minutes: " + this.runTime + "\n" +
                "Stars Nick Cage: " + this.starsNickCage + "\n" +
                "MPCRS Rating: " + this.rating + "\n" +
                "Year of Release: " + this.yearOfRelease;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(Object obj, double cost) {
        if (obj instanceof DVD) {
            this.cost = cost * .10;
        } else {
            this.cost = cost;
        }

    }

    public double getRunTime() {
        return runTime;
    }

    public void setRunTime(double runTime) {
        this.runTime = runTime;
    }

    public boolean getStarsNickCage() {
        return starsNickCage;
    }

    public void setStarsNickCage(boolean starsNickCage) {
        this.starsNickCage = starsNickCage;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }
}
