package game;

import javax.swing.*;
import java.io.Serializable;
import java.util.HashMap;

public class Game {
    public static HashMap<String,Integer> inventory;
    public static HashMap<String,Integer> prices;
    public static final int capacityPerItem = 20;
    private static long gold = 0;


    private JPanel[]  gamefield;
    public Game(){
        gamefield = new JPanel[16];
        gold = 0;
    }

    public static void incrementGold(long amount){
        gold += amount;
    }
}
