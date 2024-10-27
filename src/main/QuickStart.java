package main;

import main.model.movie.Bluray;
import main.model.movie.Movie;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static com.mongodb.client.model.Filters.eq;

public class QuickStart {
    public static void main( String[] args ) throws FileNotFoundException {
        // Replace the placeholder with your MongoDB deployment's connection string
        String uri = "mongodb+srv://jason:W98ZYGXvqjqBiQLI@cluster0.ijrik.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
        MongoCollection<Document> collection;
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("Movie_Store");
            collection = database.getCollection("movie-store");
            Document doc = collection.find(eq("Name", "Hot Rod")).first();
            if (doc != null) {
                System.out.println(doc.toJson());

            } else {
                System.out.println("No record. Creating now.");
                ArrayList<Bluray> blurays = new ArrayList<>();
                ArrayList<Movie> movie = scanFile();
                blurays.add(new Bluray(movie.get(0).getName(), movie.get(0).getCost(), movie.get(0).getRunTime(),
                        movie.get(0).getStarsNickCage(), movie.get(0).getRating(), movie.get(0).getYearOfRelease()));

                Document movieToAdd = new Document("Name", blurays.get(0).getName());

                movieToAdd.append("Cost", blurays.get(0).getCost());
                movieToAdd.append("Run Time", blurays.get(0).getRunTime());
                movieToAdd.append("Stars Nick Cage", blurays.get(0).getStarsNickCage());
                movieToAdd.append("Rating", blurays.get(0).getRating());
                movieToAdd.append("Year of Release", blurays.get(0).getYearOfRelease());
                movieToAdd.append("Type ", blurays.get(0).getClass().getSimpleName());
                collection.insertOne(movieToAdd);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Movie> scanFile() throws FileNotFoundException {
        ArrayList<Movie> movieToReturn = new ArrayList<>();
        FileInputStream fis = new FileInputStream("movie-list.txt");
        Scanner scan = new Scanner(fis).useDelimiter(",");
        String name = scan.next();
        double cost = scan.nextDouble();
        double runTime = scan.nextDouble();
        boolean starsNickCage = scan.nextBoolean();
        String rating = scan.next();
        int yearOfRelease = scan.nextInt();
        movieToReturn.add(new Movie(name, cost, runTime, starsNickCage, rating, yearOfRelease));

        return movieToReturn;
    }
}