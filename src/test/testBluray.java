package test;

import main.model.movie.Bluray;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testBluray {

    Bluray bluray;
    Bluray bluray2;

    @Before
    public void setup() {
        bluray = new Bluray("Who Shot Roger Rabbit", 50, 178, false, "PG13", 1992);
        bluray2 = new Bluray("The Rock", 100, 174, true, "R", 1992);
    }

    @Test
    public void testBlurayDiscount() {
        Assert.assertEquals(50, bluray.getCost(), 0);
    }

    @Test
    public void testNickCageDiscount() {
        Assert.assertEquals(96, bluray2.getCost(), 0);
    }

    @Test
    public void testRentalDiscount() {
        bluray.rentalDiscount();
        bluray2.rentalDiscount();
        Assert.assertEquals(12.50, bluray.getCost(), 0);
        Assert.assertEquals(24, bluray2.getCost(), 0);
    }
}
