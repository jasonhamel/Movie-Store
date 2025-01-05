package main;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        DataConnection.getInstance().collection.drop();
        FileLoader.loadFiles();
        Searcher.findName("Hot Rod");

        // Question for Erich. When you have a huge database,
        // and you want the user to be able to apply filters,
        // do you need to make a unique method for all the possible combos?
    }
}