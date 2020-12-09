package game;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Player {
    public static final int capacityPerItem = 20;
    public HashMap<String,Integer> inventory = new HashMap<>();
    private long gold;

    public Player(long initalGold){
        gold = initalGold;
    }

    public void incrementGold(long gold) {
        this.gold += gold;
    }

    public void decraseGold(long gold) {
        this.gold -= gold;
    }

    public long getGold() {
        return gold;
    }

    public void setGold(long quantity) {
        gold = quantity;
    }

    public void initPlayersInventory() throws FileNotFoundException {
        Gson gson =  new Gson();
        inventory = gson.fromJson( new FileReader(new File("").getAbsolutePath().concat("/resources/prices.json")), inventory.getClass());

        for (String item: inventory.keySet()){
            inventory.put(item, 0);
        }
    }
}
