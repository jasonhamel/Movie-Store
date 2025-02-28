import model.movie.DVD;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testDVD {

    DVD dvd;
    DVD dvd2;

    @BeforeEach
    public void setup() {
        dvd = new DVD("Turbulent Juice", 50, 90, false, "R", 2022);
        dvd2 = new DVD("Face Off", 100, 120, true, "PG13", 1999);
    }

    @Test
    public void testDVDDiscount() {
        Assertions.assertEquals(5, dvd.getCost(), 0);
    }

    @Test
    public void testNickCageDiscount() {
        Assertions.assertEquals(9.6, dvd2.getCost(), 0);
    }

    @Test
    public void testRentalDiscount() {
        dvd.rentalDiscount();
        dvd2.rentalDiscount();
        Assertions.assertEquals(1.25, dvd.getCost(), 0);
        Assertions.assertEquals(2.40, dvd2.getCost(), 0);
    }
}
