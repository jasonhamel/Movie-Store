import model.movie.Bluray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class testBluray {

    Bluray bluray;
    Bluray bluray2;

    @BeforeEach
    public void setup() {
        bluray = new Bluray("Who Shot Roger Rabbit", 50, 178, false, "PG13", 1992);
        bluray2 = new Bluray("The Rock", 100, 174, true, "R", 1992);
    }

    @Test
    public void testBlurayDiscount() {
        Assertions.assertEquals(50, bluray.getCost(), 0);
    }

    @Test
    public void testNickCageDiscount() {
        Assertions.assertEquals(96, bluray2.getCost(), 0);
    }

    @Test
    public void testRentalDiscount() {
        bluray.rentalDiscount();
        bluray2.rentalDiscount();
        Assertions.assertEquals(12.50, bluray.getCost(), 0);
        Assertions.assertEquals(24, bluray2.getCost(), 0);
    }
}
