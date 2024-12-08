package main;

import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import main.model.movie.Bluray;
import main.model.movie.DVD;
import main.model.movie.HDDVD;
import main.model.movie.Movie;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static com.mongodb.client.model.Filters.eq;

public class DataConnection {
    public static void main( String[] args ) {
        final String DB_KEY = System.getenv("DB_KEY");
        String uri = "mongodb+srv://jason:" + DB_KEY + "@cluster0.ijrik.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
        MongoCollection<Document> collection;

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("Movie_Store");
            collection = database.getCollection("movies");
            Document doc = collection.find(eq("Name", "Hot Rod")).first();
            if (doc != null) {
                System.out.println("Emptying database");
                collection.drop();
            }
            System.out.println("No record. Creating now.");
            ArrayList<Movie> moviesFromFile = scanFile();
            ArrayList<Document> moviesToAdd = new ArrayList<>();

            for (Movie movie: moviesFromFile) {
                moviesToAdd.add(getDocument(new HDDVD(movie)));
                moviesToAdd.add(getDocument(new Bluray(movie)));
                moviesToAdd.add(getDocument(new DVD(movie)));
            }

            collection.insertMany(moviesToAdd);


        } catch (
                FileNotFoundException e) {
            throw new RuntimeException(e);
        }
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

    public static void checkForDVD(String title) {
       DVD foundDVD;
        final String DB_KEY = System.getenv("DB_KEY");
        String uri = "mongodb+srv://jason:" + DB_KEY + "@cluster0.ijrik.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";


        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("Movie_Store");
            MongoCollection<Document> movieFromDB = database.getCollection("movies");

           Document doc = movieFromDB.aggregate(
                   Arrays.asList(
               Aggregates.match(Filters.eq("Name", title)),
               Aggregates.match(Filters.eq("Type", "DVD"))
           )).first();
            System.out.println(doc);
            //Erich challenge is to DRY up the code and send 3 collections only
        }
    }
}


