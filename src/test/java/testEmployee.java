import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testEmployee {
    Employee employee;

    @BeforeEach
    public void setup() {
        employee = new Employee ("Jason Hamel", 1);
    }

    @Test
    public void testGetName() {
        Assertions.assertEquals("Jason Hamel", employee.getName());
    }

    @Test
    public void testGetEmployeeNumber() {
        Assertions.assertEquals(1, employee.getEmployeeNumber());
    }

    @Test
    public void testPunchIn() {
        Assertions.assertFalse(employee.getPunchStatus());
        employee.punch();
        Assertions.assertTrue(employee.getPunchStatus());
    }
}
