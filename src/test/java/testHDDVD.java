import model.movie.HDDVD;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class testHDDVD {

    HDDVD hddvd;
    HDDVD hddvd2;

    @BeforeEach
    public void setup() {
        hddvd = new HDDVD("Hot Fuzz", 50, 200, false, "PG13", 2005);
        hddvd2 = new HDDVD("National Treasure", 100, 202, true, "PG13", 2001);
    }

    @Test
    public void testHDDVDDiscount() {
        Assertions.assertEquals(25, hddvd.getCost(), 0);
    }

    @Test
    public void testNickCageDiscount() {
        Assertions.assertEquals(48, hddvd2.getCost(), 0);
    }

    @Test
    public void testRentalDiscount() {
        hddvd.rentalDiscount();
        hddvd2.rentalDiscount();
        Assertions.assertEquals(6.25, hddvd.getCost(), 0);
        Assertions.assertEquals(12, hddvd2.getCost(), 0);
    }
}
