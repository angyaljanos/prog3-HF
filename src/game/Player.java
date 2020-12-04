package game;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Player {
    public HashMap<String,Integer> inventory = new HashMap<>();
    public static final int capacityPerItem = 20;
    public long gold;

    private LocalDateTime lastSaved;

    public Player(){
        gold = 3;
    }

    public void setCurrentDate(){
        lastSaved = LocalDateTime.now();
    }

    public String getLastSavedDate(){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return lastSaved.format(dateFormatter);
    }

    public void setInventory(HashMap<String, Integer> inventory) {
        this.inventory = inventory;
    }

    public void incrementGold(long gold) {
        this.gold += gold;
    }

    public void decraseGold(long gold) {
        this.gold += gold;
    }

    public HashMap<String, Integer> getInventory() {
        return inventory;
    }

    public long getGold() {
        return gold;
    }

    public LocalDateTime getLastSaved() {
        return lastSaved;
    }

    public void setGold(long quantity) {
        gold = quantity;
    }
}
