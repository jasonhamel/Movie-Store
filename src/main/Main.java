package main;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        DataConnection.getInstance();
        DataConnection.getInstance().collection.drop();
        FileLoader.loadFiles();
    }
}