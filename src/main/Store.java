package main;

import main.model.movie.Bluray;
import main.model.movie.DVD;
import main.model.movie.HDDVD;
import main.model.movie.Movie;

import java.util.HashMap;

public class Store {
    private static Store store_inventory = null;
    private HashMap<String, Integer> dvdStock = new HashMap<>();
    private HashMap<String, Integer> hddvdStock = new HashMap<>();
    private HashMap<String, Integer> blurayStock = new HashMap<>();

    private Store() {
    }

    public static Store getInstance() {
       Store result = store_inventory;
       if (store_inventory == null) {
           synchronized (Store.class) {
                result = store_inventory;
                if (result == null) {
                    store_inventory = new Store();
                }
           }
       }
       return store_inventory;
    }

    public int getMovie(Movie movie) {
        int typeOfMovie = getTypeOfMovie(movie);
        if (typeOfMovie == 1) {
            return dvdStock.get(movie.getName());
        } else if (typeOfMovie == 2) {
            return hddvdStock.get(movie.getName());
        } else if (typeOfMovie == 3) {
            return blurayStock.get(movie.getName());
        }
        return 404;
    }

    public void changeStock(Movie movie, int quantity) {
        String name = movie.getName();
        int type = getTypeOfMovie(movie);
        if (checkIfInStock(type, quantity, name)) {
            if (type == 1) {
                if (dvdStock.get(name) == null) {
                    dvdStock.put(name, quantity);
                } else {
                    dvdStock.put(name, dvdStock.get(name) + quantity);
                }
            } else if (type == 2) {
                if (hddvdStock.get(name) == null) {
                    hddvdStock.put(name, quantity);
                } else {
                    hddvdStock.put(name, hddvdStock.get(name) + quantity);
                }
            } else if (type == 3) {
                if (blurayStock.get(name) == null) {
                    blurayStock.put(name, quantity);
                } else {
                    blurayStock.put(name, blurayStock.get(name) + quantity);
                }
            }
        } else {
            System.out.println("Not enough copies in stock");
        }

    }

    public int getTypeOfMovie(Movie movie) {
        if (movie instanceof DVD) {
            return 1;
        } else if (movie instanceof HDDVD) {
            return 2;
        } else if (movie instanceof Bluray) {
            return 3;
        }
        return 0;
    }

    public boolean checkIfInStock(int type, int quantity, String name) {
        if (type == 1 && dvdStock.get(name) != null) {
            if (dvdStock.get(name) + quantity < 0) {
                return false;
            }
        } else if (type == 2 && hddvdStock.get(name) != null) {
            if (hddvdStock.get(name) + quantity < 0) {
                return false;
            }
        } else if (type == 3 && blurayStock.get(name) != null) {
            if (blurayStock.get(name) + quantity < 0) {
                return false;
            }
        }
        return true;
    }

    public void clearStore() {
        dvdStock.clear();
        hddvdStock.clear();
        blurayStock.clear();
    }
}
