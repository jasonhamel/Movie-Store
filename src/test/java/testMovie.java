package java;


import model.movie.Bluray;
import model.movie.DVD;
import model.movie.HDDVD;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class testMovie {
    Bluray bluray;
    HDDVD hddvd;
    DVD dvd;

    @Before("")
    public void setup() {
        bluray = new Bluray("Gone in 60 Seconds", 20, 90, true, "PG13", 1995);
        hddvd = new HDDVD("Gone in 60 Seconds", 20, 90, true, "PG13", 1995);
        dvd = new DVD("Gone in 60 Seconds", 20, 90, true, "PG13", 1995);
    }

    @Test
    public void testMovies() {
        Assertions.assertSame("Gone in 60 Seconds", bluray.getName());
        Assertions.assertSame("Gone in 60 Seconds", hddvd.getName());
        Assertions.assertSame("Gone in 60 Seconds", dvd.getName());
    }
}
