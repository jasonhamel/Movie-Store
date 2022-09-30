package test;

import main.model.movie.Bluray;
import main.model.movie.DVD;
import main.model.movie.HDDVD;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testMovie {
    Bluray bluray;
    HDDVD hddvd;
    DVD dvd;

    @Before
    public void setup() {
        bluray = new Bluray("Gone in 60 Seconds", 20, 90, true, "PG13", 1995);
        hddvd = new HDDVD("Gone in 60 Seconds", 20, 90, true, "PG13", 1995);
        dvd = new DVD("Gone in 60 Seconds", 20, 90, true, "PG13", 1995);
    }

    @Test
    public void testMovies() {
        Assert.assertSame("Gone in 60 Seconds", bluray.getName());
        Assert.assertSame("Gone in 60 Seconds", hddvd.getName());
        Assert.assertSame("Gone in 60 Seconds", dvd.getName());
    }
}
