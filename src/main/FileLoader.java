package main;

import main.model.movie.Bluray;
import main.model.movie.DVD;
import main.model.movie.HDDVD;
import main.model.movie.Movie;
import org.bson.Document;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileLoader {
    public static void loadFiles() {

        ArrayList<Movie> moviesFromFile;
        try {
            moviesFromFile = scanFile();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Document> moviesToAdd = new ArrayList<>();

        for (Movie movie : moviesFromFile) {
            moviesToAdd.add(getDocument(new HDDVD(movie)));
            moviesToAdd.add(getDocument(new Bluray(movie)));
            moviesToAdd.add(getDocument(new DVD(movie)));
        }

                DataConnection.getInstance().collection.insertMany(moviesToAdd);

    }

    private static Document getDocument(Movie movie) {
        Document movieToAdd = new Document("Name", movie.getName());

        movieToAdd.append("Cost", movie.getCost());
        movieToAdd.append("Run Time", movie.getRunTime());
        movieToAdd.append("Stars Nick Cage", movie.getStarsNickCage());
        movieToAdd.append("Rating", movie.getRating());
        movieToAdd.append("Year of Release", movie.getYearOfRelease());
        movieToAdd.append("Type", movie.getClass().getSimpleName());
        return movieToAdd;
    }

    private static ArrayList<Movie> scanFile() throws FileNotFoundException {
        ArrayList<Movie> movieToReturn = new ArrayList<>();
        FileInputStream fis = new FileInputStream("movie-list.txt");
        Scanner scan = new Scanner(fis).useDelimiter(",");
        while (scan.hasNext()) {
            String name = scan.next();
            double cost = scan.nextDouble();
            double runTime = scan.nextDouble();
            boolean starsNickCage = scan.nextBoolean();
            String rating = scan.next();
            int yearOfRelease = scan.nextInt();
            movieToReturn.add(new Movie(name, cost, runTime, starsNickCage, rating, yearOfRelease));
        }

        scan.close();
        return movieToReturn;
    }
}
