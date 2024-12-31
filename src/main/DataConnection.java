package main;

import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import main.model.movie.DVD;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.Arrays;

public class DataConnection {
    private static DataConnection instance;
    MongoCollection<Document> collection;

    private DataConnection() {
        final String DB_KEY = System.getenv("DB_KEY");
        String uri = "mongodb+srv://jason:" + DB_KEY + "@cluster0.ijrik.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";

        MongoClient mongoClient = MongoClients.create(uri);
        MongoDatabase database = mongoClient.getDatabase("Movie_Store");
        collection = database.getCollection("movies");
    }

    public static synchronized DataConnection getInstance() {
        if (instance == null) {
            instance = new DataConnection();
        }
        return instance;
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


