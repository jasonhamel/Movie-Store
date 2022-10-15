package main;

public class Employee {

    private String name;
    private int employeeNumber;

    private boolean punchStatus;

    public Employee( String name, int employeeNumber) {
        this.name = name;
        this.employeeNumber = employeeNumber;
        this.punchStatus = false;
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

    public boolean getPunchStatus() {
        return punchStatus;
    }

    public void setPunchStatus(boolean punchStatus) {
        this.punchStatus = punchStatus;
    }

    public boolean punch() {
        changePunchStatus();
        return this.punchStatus;
    }

    public void changePunchStatus() {
        if (!this.punchStatus) {
            setPunchStatus(true);
        } else {
            setPunchStatus(false);
        }
    }
}
