package game;

import java.util.HashMap;

public class Player {
    public static HashMap<String,Integer> inventory;
    public static final int capacityPerItem = 20;
    public static long gold = 0;

    private String name;

    public Player(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println(name);
    }
}
