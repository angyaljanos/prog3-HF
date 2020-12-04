package game;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Player {
    public static HashMap<String,Integer> inventory;
    public static final int capacityPerItem = 20;
    public static long gold = 0;

    private LocalDateTime lastSaved;

    public void setCurrentDate(){
        lastSaved = LocalDateTime.now();
    }
    public String getLastSavedDate(){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return lastSaved.format(dateFormatter);
    }
}
