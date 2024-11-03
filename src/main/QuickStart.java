package main;

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
                ArrayList<HDDVD> hddvds = createHDDVDs();
                ArrayList<Bluray> blurays = createBlurays();
                ArrayList<DVD> dvds = createDVDs();

                for (HDDVD hddvd : hddvds) {
                    Document movieToAdd = new Document("Name", hddvd.getName());

                    movieToAdd.append("Cost", hddvd.getCost());
                    movieToAdd.append("Run Time", hddvd.getRunTime());
                    movieToAdd.append("Stars Nick Cage", hddvd.getStarsNickCage());
                    movieToAdd.append("Rating", hddvd.getRating());
                    movieToAdd.append("Year of Release", hddvd.getYearOfRelease());
                    movieToAdd.append("Type ", hddvd.getClass().getSimpleName());
                    collection.insertOne(movieToAdd);
                }

                for (Bluray bluray : blurays) {
                    Document movieToAdd = new Document("Name", bluray.getName());

                    movieToAdd.append("Cost", bluray.getCost());
                    movieToAdd.append("Run Time", bluray.getRunTime());
                    movieToAdd.append("Stars Nick Cage", bluray.getStarsNickCage());
                    movieToAdd.append("Rating", bluray.getRating());
                    movieToAdd.append("Year of Release", bluray.getYearOfRelease());
                    movieToAdd.append("Type ", bluray.getClass().getSimpleName());
                    collection.insertOne(movieToAdd);
                }

                for (DVD dvd : dvds) {
                    Document movieToAdd = new Document("Name", dvd.getName());

                    movieToAdd.append("Cost", dvd.getCost());
                    movieToAdd.append("Run Time", dvd.getRunTime());
                    movieToAdd.append("Stars Nick Cage", dvd.getStarsNickCage());
                    movieToAdd.append("Rating", dvd.getRating());
                    movieToAdd.append("Year of Release", dvd.getYearOfRelease());
                    movieToAdd.append("Type ", dvd.getClass().getSimpleName());
                    collection.insertOne(movieToAdd);
                }

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<HDDVD> createHDDVDs() throws FileNotFoundException {
        ArrayList<HDDVD> hddvds = new ArrayList<>();
        ArrayList<Movie> movies = scanFile();

        for (int i = 0; i < movies.size(); i++) {
            hddvds.add(new HDDVD(movies.get(i).getName(), movies.get(i).getCost(), movies.get(i).getRunTime(),
                    movies.get(i).getStarsNickCage(), movies.get(i).getRating(), movies.get(i).getYearOfRelease()));
        }
        return hddvds;
    }

    public static ArrayList<Bluray> createBlurays() throws FileNotFoundException {
        ArrayList<Bluray> blurays = new ArrayList<>();
        ArrayList<Movie> movies = scanFile();

        for (int i = 0; i < movies.size(); i++) {
            blurays.add(new Bluray(movies.get(i).getName(), movies.get(i).getCost(), movies.get(i).getRunTime(),
                    movies.get(i).getStarsNickCage(), movies.get(i).getRating(), movies.get(i).getYearOfRelease()));
        }
        return blurays;
    }

    public static ArrayList<DVD> createDVDs() throws FileNotFoundException {
        ArrayList<DVD> dvds = new ArrayList<>();
        ArrayList<Movie> movies = scanFile();

        for (int i = 0; i < movies.size(); i++) {
            dvds.add(new DVD(movies.get(i).getName(), movies.get(i).getCost(), movies.get(i).getRunTime(),
                    movies.get(i).getStarsNickCage(), movies.get(i).getRating(), movies.get(i).getYearOfRelease()));
        }
        return dvds;
    }

    public static ArrayList<Movie> scanFile() throws FileNotFoundException {
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


        return movieToReturn;
    }
}