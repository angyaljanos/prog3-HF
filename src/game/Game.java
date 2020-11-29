package game;

import javax.swing.*;
import java.util.HashMap;

public class Game {
    private JPanel[]  gamefield;
    public static HashMap<String,Integer> inventory;
    public Game(){
        gamefield = new JPanel[16];
    }
}
