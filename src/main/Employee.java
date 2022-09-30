package main;

public class Employee {

    private String name;
    private int employeeNumber;

    public Employee( String name, int employeeNumber) {
        this.name = name;
        this.employeeNumber = employeeNumber;
    }

    @Override
    public String toString() {
        return "Employee Name: " + this.name + "\n" +
                "Employee Number: " + this.employeeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    private void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }
}
