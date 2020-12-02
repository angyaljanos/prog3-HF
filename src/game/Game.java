package game;

import com.google.gson.Gson;
import hw.MainFrame;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;

public class Game {
    public static HashMap<String,Integer> prices;
    private ingameMenuSlide menuSlide;
    private JPanel container;
    private baseBuilding[] gamefields = new baseBuilding[16];;
    private Player player;
    GridLayout grid = new GridLayout(4,4);

    public Game(MainFrame mainFrame){
        container = new JPanel();
        player = new Player();
        menuSlide = new ingameMenuSlide(mainFrame,player);
        Player.gold = 0;

        setPrices();
    }

    public void showTiles(MainFrame mainFrame) throws IOException {
        mainFrame.mainPanel.setLayout(grid);

        for(baseBuilding item: gamefields){
            item = new baseBuilding();


            mainFrame.mainPanel.add(item);
            mainFrame.pack();
        }

    }

    public void newGame(MainFrame mainFrame){
        try {
            nameInsertForm nameInsertForm = new nameInsertForm();
            player.setName(nameInsertForm.getName());

            showTiles(mainFrame);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void continuePreviousGame(MainFrame mainFrame){
        try {//keress képeket és vágd körbe őket
            showTiles(mainFrame);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void setPrices(){
       //prices = new ObjectMapper().readValue(JSON_SOURCE, HashMap.class);

    }

    public void save(){
        Gson gson = new Gson();
    }

}
