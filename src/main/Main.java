package main;

import main.model.movie.HDDVD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



public class Main {
    public static void main(String[] args) {
        final String DB_URL = "jdbc:mysql://localhost:3306/moviestore";
        final String USERNAME = "root";
        final String PASSWORD = "1234";
        System.out.println("Hello world!");
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

        try {
            Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "INSERT INTO transaction " +
                    "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 9);
            preparedStatement.setString(2, "Wendel");
            preparedStatement.setString(3, "56");
            preparedStatement.setInt(4, 400);
            preparedStatement.setDate(5, Date.valueOf("2222-12-22"));
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}