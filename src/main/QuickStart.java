package main;

import main.model.movie.Bluray;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.eq;

public class QuickStart {
    public static void main( String[] args ) {
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
                System.out.println("No matching documents found.");
                Bluray br1 = new Bluray("Hot Rod", 19.99, 90, false, "five", 2007);
                Document movieToAdd = new Document("Name", br1.getName());

                movieToAdd.append("Cost", br1.getCost());
                movieToAdd.append("Run Time", br1.getRunTime());
                movieToAdd.append("Stars Nick Cage", br1.getStarsNickCage());
                movieToAdd.append("Rating", br1.getRating());
                movieToAdd.append("Year of Release", br1.getYearOfRelease());
                movieToAdd.append("Type ", br1.getClass().getSimpleName());
                collection.insertOne(movieToAdd);
            }
        }
    }
}