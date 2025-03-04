import model.movie.Movie;

import java.util.HashMap;

public class Store {
    private static Store store_inventory = null;
    private HashMap<String, Integer> dvdStock = new HashMap<>();
    private HashMap<String, Integer> hddvdStock = new HashMap<>();
    private HashMap<String, Integer> blurayStock = new HashMap<>();

    private boolean storeStatus = false;

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
        if (movie.getFormat().equalsIgnoreCase("DVD")) {
            return dvdStock.get(movie.getName());
        } else if (movie.getFormat().equalsIgnoreCase("HDDVD")) {
            return hddvdStock.get(movie.getName());
        } else if (movie.getFormat().equalsIgnoreCase("BLURAY")) {
            return blurayStock.get(movie.getName());
        }
        return 404;
    }

    public void changeStock(Movie movie, int quantity) {
        String name = movie.getName();
        String type = movie.getFormat();
        if (checkIfInStock(type, quantity, name)) {
            if (type.equalsIgnoreCase("DVD")) {
                dvdStock.merge(name, quantity, Integer::sum);
            } else if (type.equalsIgnoreCase("HDDVD")) {
                hddvdStock.merge(name, quantity, Integer::sum);
            } else if (type.equalsIgnoreCase("BLURAY")) {
                blurayStock.merge(name, quantity, Integer::sum);
            }
        } else {
            System.out.println("Not enough copies in stock");
        }

    }

    public boolean checkIfInStock(String type, int quantity, String name) {
        if (type.equalsIgnoreCase("DVD") && dvdStock.get(name) != null) {
            return dvdStock.get(name) + quantity >= 0;
        } else if (type.equalsIgnoreCase("HDDVD") && hddvdStock.get(name) != null) {
            return hddvdStock.get(name) + quantity >= 0;
        } else if (type.equalsIgnoreCase("BLURAY") && blurayStock.get(name) != null) {
            return blurayStock.get(name) + quantity >= 0;
        }
        return true;
    }

    public boolean getStoreStatus() {
        return storeStatus;
    }

    public void setStoreStatus(boolean storeStatus) {
        this.storeStatus = storeStatus;
    }

    public void clearStore() {
        dvdStock.clear();
        hddvdStock.clear();
        blurayStock.clear();
    }

    public void openStore() {
        setStoreStatus(true);
    }

    public void closeStore() {
        //Print Store Inventory
        //Print Amount of Money Made
        setStoreStatus(false);
    }
}
