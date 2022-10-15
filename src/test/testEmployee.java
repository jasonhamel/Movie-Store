package test;

import main.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testEmployee {
    Employee employee;

    @Before
    public void setup() {
        employee = new Employee ("Jason Hamel", 1);
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("Jason Hamel", employee.getName());
    }

    @Test
    public void testGetEmployeeNumber() {
        Assert.assertEquals(1, employee.getEmployeeNumber());
    }

    @Test
    public void testPunchIn() {
        Assert.assertEquals(false, employee.getPunchStatus());
        employee.punch();
        Assert.assertEquals(true, employee.getPunchStatus());
    }
}
