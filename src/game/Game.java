package game;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import hw.MainFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.HashMap;

public class Game {
    public static HashMap prices = new HashMap<String,Integer>();
    private static JPanel container;
    private static baseBuilding[] gamefields = new baseBuilding[16];;

    private static GridLayout grid = new GridLayout(4,4);

    private Player player;
    private ingameMenuSlide menuSlide;

    public Game(MainFrame mainFrame) throws FileNotFoundException {
        container = new JPanel();
        player = new Player();
        menuSlide = new ingameMenuSlide(mainFrame,player,this);

        setPrices();
    }

    private void initTiles(MainFrame mainFrame) throws IOException {
        container.setLayout(grid);
        menuSlide.setVisible(true);
        for(baseBuilding item: gamefields){
            item = new baseBuilding(player, mainFrame);
            container.add(item);
        }

        mainFrame.mainPanel.add(container);
    }

    public void newGame(MainFrame mainFrame){
        try {
            initPlayersInventory();
            initTiles(mainFrame);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    private void initPlayersInventory() throws FileNotFoundException {
        Gson gson =  new Gson();
        player.inventory = gson.fromJson( new FileReader(new File("").getAbsolutePath().concat("/resources/prices.json")), player.getInventory().getClass());
        for (String item: player.inventory.keySet()){
            player.inventory.put(item, 0);
        }
    }

    public void continuePreviousGame(MainFrame mainFrame){
        try {
            initTiles(mainFrame);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public  void setPrices() throws FileNotFoundException {
        prices.clear();
        Gson gson =  new Gson();
        prices = gson.fromJson( new FileReader(new File("").getAbsolutePath().concat("/resources/prices.json")), prices.getClass());
        System.out.println("prices.size:" + prices.keySet().size());
    }

    public void save() throws IOException {
        Gson gson = new Gson();
        FileWriter fileWriter = new FileWriter(new File("").getAbsolutePath().concat("/resources/game.json"));
        gson.toJson(player, fileWriter);

        fileWriter.close();
    }

    public static baseBuilding[] getGameFileds(){
        return gamefields;
    }
}
