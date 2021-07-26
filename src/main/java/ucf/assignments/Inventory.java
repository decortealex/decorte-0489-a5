package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Inventory {
    private ArrayList<InventoryItem> inventory;

    public Inventory() {
        inventory = new ArrayList<>();
    }

    public InventoryItem getItem(int index) {
        return inventory.get(index);
    }

    public InventoryItem getItemByName(String name) {
        for(InventoryItem item : inventory) {
            if(item.getName().equalsIgnoreCase(name))
                return item;
        }
        return null;
    }

    public void addItem(InventoryItem item) {
        inventory.add(item);
    }

    public void deleteItem(int index) {
        inventory.remove(index);
    }

    public void clearAllItems() {
        inventory.clear();
    }

    public ObservableList<InventoryItem> forListView() {
        return FXCollections.observableArrayList(inventory);
    }
}

class InventoryItem {
    private String name;
    private String serial;
    private double price;
    private final ConcurrentMap<String, AtomicInteger> _sequence = new ConcurrentHashMap<>();

    public InventoryItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.setSerial();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial() {
        String first_three = this.name.substring(0, 3);

        String key = first_three + (int) (Math.random() * 999);
        AtomicInteger chk = new AtomicInteger(0);
        AtomicInteger ai = _sequence.putIfAbsent(key, chk);
        if(ai == null) {
            ai = chk;
        }

        int val = ai.incrementAndGet();
        String fmt = String.format("%03d", val);

        serial = (key + fmt);
    }


}
