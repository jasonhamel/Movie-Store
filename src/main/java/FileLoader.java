import com.JasonVideo.Movie_Store.Model.Movie;
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
            moviesToAdd.add(getDocument(movie));
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
        movieToAdd.append("Type", movie.getFormat());
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
            String format = scan.next();
            movieToReturn.add(new Movie(name, cost, runTime, starsNickCage, rating, yearOfRelease, format));
        }

        scan.close();
        return movieToReturn;
    }
}
