package test;

import main.Employee;
import main.Transaction;
import main.model.movie.Bluray;
import main.model.movie.DVD;
import main.model.movie.HDDVD;
import main.model.movie.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class testTransaction {

    Transaction[] transactions;
    Employee[] employees = new Employee[] {
            new Employee("Jason", 1),
            new Employee("Gillian", 2)
    };
    Movie[] movies = new Movie[] {
            new DVD("Gone in 60 Seconds", 40, 60, true, "PG13", 1998),
            new DVD("Lord of the Rings", 40, 120, false, "PG13", 1998),
            new HDDVD("Gone in 60 Seconds", 40, 60, true, "PG13", 1998),
            new HDDVD("Lord of the Rings", 40, 120, false, "PG13", 1998),
            new Bluray("Gone in 60 Seconds", 40, 60, true, "PG13", 1998),
            new Bluray("Lord of the Rings", 40, 120, false, "PG13", 1998)
    };

    @Before
    public void setup() {
        transactions = new Transaction[] {
            new Transaction(345232245, employees[0].getName(), employees[0].getEmployeeNumber(), movies[0].getCost(), new Date()),
                new Transaction(324522, employees[1].getName(), employees[1].getEmployeeNumber(), movies[4].getCost(), new Date())
        };
    }

    @Test
    public void testGetTransaction() {
        System.out.println(transactions[0]);
        System.out.println(transactions[1]);
    }
}
