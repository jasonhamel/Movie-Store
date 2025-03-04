import model.movie.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testTransaction {

    Transaction[] transactions;
    Employee[] employees = new Employee[] {
            new Employee("Jason", 1),
            new Employee("Gillian", 2)
    };
    Movie[] movies = new Movie[] {
    };

    @BeforeEach
    public void setup() {
        transactions = new Transaction[] {
                new Transaction(employees[0].getName(), employees[0].getEmployeeNumber(), movies[0].getCost()),
                new Transaction(employees[1].getName(), employees[1].getEmployeeNumber(), movies[4].getCost())
        };
    }

    @Test
    public void testGetTransaction() {
        System.out.println(transactions[0]);
        System.out.println(transactions[1]);
        Assertions.assertEquals("Jason", transactions[0].getEmployeeName());
    }
}
