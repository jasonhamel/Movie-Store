package test;

import main.model.movie.HDDVD;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testHDDVD {

    HDDVD hddvd;
    HDDVD hddvd2;

    @Before
    public void setup() {
        hddvd = new HDDVD("Hot Fuzz", 50, 200, false, "PG13", 2005);
        hddvd2 = new HDDVD("National Treasure", 100, 202, true, "PG13", 2001);
    }

    @Test
    public void testHDDVDDiscount() {
        Assert.assertEquals(25, hddvd.getCost(), 0);
    }

    @Test
    public void testNickCageDiscount() {
        Assert.assertEquals(48, hddvd2.getCost(), 0);
    }

    @Test
    public void testRentalDiscount() {
        hddvd.rentalDiscount();
        hddvd2.rentalDiscount();
        Assert.assertEquals(6.25, hddvd.getCost(), 0);
        Assert.assertEquals(12, hddvd2.getCost(), 0);
    }
}
