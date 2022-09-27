package main;

import java.util.HashMap;
import java.util.Objects;

public class Store {
    private static Store store_inventory = null;
    private HashMap<String, Integer> storeStock = new HashMap<>();

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
     public void changeStock(String name, int quantity) {
        if (storeStock.containsKey(name)) {
            storeStock.put(name, quantity + storeStock.get(name));
        } else {
            storeStock.put(name, quantity);
        }
        System.out.println(storeStock);
     }
}
