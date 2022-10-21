package main;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class Transaction {

    private long transactionID;
    private String employeeName;
    private int employeeID;
    private double cost;
    private Date date = new Date();

    public Transaction(String employeeName, int employeeID, double cost, Date date) {
        this.transactionID = generateTransactionID();
        this.employeeName = employeeName;
        this.employeeID = employeeID;
        this.cost = cost;
        this.date = date;
    }

    public Transaction(Transaction source) {
        this.transactionID = generateTransactionID();
        this.employeeName = source.employeeName;
        this.employeeID = source.employeeID;
        this.cost = source.cost;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction ID: " + transactionID + "\n" +
                "Employee Name: " + employeeName + "\n" +
                "Employee ID: " + employeeID + "\n" +
                "Cost: " + cost + "\n" +
                "Date: " + date;
    }

    public long getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(long transactionID) {
        this.transactionID = transactionID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public static long generateTransactionID() {
        return ThreadLocalRandom.current().nextLong(1, 999999999);
    }
}
