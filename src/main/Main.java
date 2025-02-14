package main;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        DataConnection.getInstance().collection.drop();
        FileLoader.loadFiles();
        Searcher.findName("Hot Rod");

        // Version and merge to main
        // New project for Spring using the initializer
        // New branch for new project?
        // Search method to start
    }
}