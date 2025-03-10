import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

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

}