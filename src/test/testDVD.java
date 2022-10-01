package test;

import main.model.movie.DVD;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testDVD {

    DVD dvd;
    DVD dvd2;

    @Before
    public void setup() {
        dvd = new DVD("Turbulent Juice", 50, 90, false, "R", 2022);
        dvd2 = new DVD("Face Off", 100, 120, true, "PG13", 1999);
    }

    @Test
    public void testDVDDiscount() {
        Assert.assertEquals(5, dvd.getCost(), 0);
    }

    @Test
    public void testNickCageDiscount() {
        Assert.assertEquals(9.6, dvd2.getCost(), 0.00000000000001);
    }

}
