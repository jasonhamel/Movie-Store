package main;

import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import java.util.List;

public class Searcher {

    public static void findName(String name) {
        DataConnection.getInstance().collection
                .aggregate(
                        List.of(
                                Aggregates.match(Filters.eq("Name", name))
                        )
                        ).forEach(doc -> System.out.println(doc.toJson()));
    }
}
