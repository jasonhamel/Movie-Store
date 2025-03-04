package test;

import main.Store;
import main.model.movie.Bluray;
import main.model.movie.DVD;
import main.model.movie.HDDVD;
import main.model.movie.Movie;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testStore {
Movie[] movies;

    @Before
    public void setup() {
        movies = new Movie[] {
                new DVD("Gone in 60 Seconds", 40, 60, true, "PG13", 1998),
                new DVD("Lord of the Rings", 40, 120, false, "PG13", 1998),
                new HDDVD("Gone in 60 Seconds", 40, 60, true, "PG13", 1998),
                new HDDVD("Lord of the Rings", 40, 120, false, "PG13", 1998),
                new Bluray("Gone in 60 Seconds", 40, 60, true, "PG13", 1998),
                new Bluray("Lord of the Rings", 40, 120, false, "PG13", 1998)
        };
    }

    @Test
    public void testAddToStoreDVD() {
        Store.getInstance().changeStock(movies[0], 6);
        Assert.assertEquals(6, Store.getInstance().getMovie(movies[0]));
        Store.getInstance().clearStore();
    }

    @Test
    public void testAddToStoreHDDVD() {
        Store.getInstance().changeStock(movies[2], 5);
        Assert.assertEquals(5, Store.getInstance().getMovie(movies[2]));
        Store.getInstance().clearStore();
    }

    @Test
    public void testAddToStoreBluray() {
        Store.getInstance().changeStock(movies[4], 99);
        Assert.assertEquals(99, Store.getInstance().getMovie(movies[4]));
        Store.getInstance().clearStore();
    }

    @Test
    public void testRemoveFromStoreDVD() {
        Store.getInstance().changeStock(movies[0], 6);
        Store.getInstance().changeStock(movies[0], -1);
        Assert.assertEquals(5, Store.getInstance().getMovie(movies[0]));
        Store.getInstance().changeStock(movies[0], -6);
        Assert.assertEquals(5, Store.getInstance().getMovie(movies[0]));
        Store.getInstance().clearStore();
    }

    @Test
    public void testRemoveFromStoreHDDVD() {
        Store.getInstance().changeStock(movies[2], 6);
        Store.getInstance().changeStock(movies[2], -1);
        Assert.assertEquals(5, Store.getInstance().getMovie(movies[2]));
        Store.getInstance().changeStock(movies[2], -6);
        Assert.assertEquals(5, Store.getInstance().getMovie(movies[2]));
        Store.getInstance().clearStore();
    }

    @Test
    public void testRemoveFromStoreBLURAY() {
        Store.getInstance().changeStock(movies[4], 6);
        Store.getInstance().changeStock(movies[4], -1);
        Assert.assertEquals(5, Store.getInstance().getMovie(movies[4]));
        Store.getInstance().changeStock(movies[4], -6);
        Assert.assertEquals(5, Store.getInstance().getMovie(movies[4]));
        Store.getInstance().clearStore();
    }
}
