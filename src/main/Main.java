package main;

import java.sql.*;
import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Hello world!");
        Transaction transaction = new Transaction("Jason", 654, 39.95);
        Timestamp timestamp = new Timestamp(transaction.getDate().getTime());
//        HDDVD movie = new HDDVD("Flatliners", 99.99, 120, false, "R", 1990);
//        System.out.println(movie);
//        System.out.println(movie.getName());
//        System.out.println(movie.getCost());
//        System.out.println(movie.getRunTime());
//        System.out.println(movie.getStarsNickCage());
//        System.out.println(movie.getRating());
//        System.out.println(movie.getYearOfRelease());
//        System.out.println();
//        movie.setName("Jason");
//        movie.setStarsNickCage(true);
//        movie.updateCost(50);
//        movie.setRunTime(999);
//        movie.setRating("PG13");
//        movie.setYearOfRelease(1987);
//        System.out.println(movie);
//        System.out.println(movie.getName());
//        System.out.println(movie.getCost());
//        System.out.println(movie.getRunTime());
//        System.out.println(movie.getStarsNickCage());
//        System.out.println(movie.getRating());
//        System.out.println(movie.getYearOfRelease());
//        Store.getInstance().changeStock(movie, 7);
//        //Store.getInstance().changeStock("Die Hard 2", 10);
//        Store.getInstance().changeStock(movie, 1);
        createTransaction(transaction, timestamp);
        readTransaction(transaction, timestamp);
        updateTransaction(transaction, timestamp);
    }

    public static void createTransaction(Transaction transaction, Timestamp timestamp) {
        try {
            final String DB_URL = "jdbc:mysql://localhost:3306/moviestore";
            final String USERNAME = "root";
            final String PASSWORD = "1234";
            Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "INSERT INTO transaction " +
                    "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, transaction.getTransactionID());
            preparedStatement.setString(2, transaction.getEmployeeName());
            preparedStatement.setInt(3, transaction.getEmployeeID());
            preparedStatement.setDouble(4, transaction.getCost());
            preparedStatement.setTimestamp(5, timestamp);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void readTransaction(Transaction transaction, Timestamp timestamp) {
        try {
            final String DB_URL = "jdbc:mysql://localhost:3306/moviestore";
            final String USERNAME = "root";
            final String PASSWORD = "1234";
            Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet queryResult = statement.executeQuery("select * from transaction where EmployeeName=\"Jason\"");
            while (queryResult.next()) {
                System.out.println(queryResult.getDouble("idTransactionID") + " " + queryResult.getString("EmployeeName") + " " + queryResult.getInt("EmployeeID") +
                        " " + queryResult.getDouble("Cost") + " " + queryResult.getDate("Date"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void updateTransaction(Transaction transaction, Timestamp timestamp) {
        try {
            final String DB_URL = "jdbc:mysql://localhost:3306/moviestore";
            final String USERNAME = "root";
            final String PASSWORD = "1234";
            Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            String sql = "update transaction set cost = 5.55 where EmployeeName=\"Jason\"";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            System.out.println(statement.executeQuery("select * from transaction where EmployeeName=\"Jason\""));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}