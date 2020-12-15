package hw.game;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.reflect.TypeToken;
import hw.JsonMaker;
import hw.MainFrame;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;

public class Game {
    public static HashMap<String,Integer> prices = new HashMap<>();
    private static JPanel container;

    public static baseBuilding[] gamefields = new baseBuilding[16];

    private static GridLayout grid = new GridLayout(4,4);

    public Player player;
    private ingameMenuSlide menuSlide;
    private final long initGold = 10;

    public Game(MainFrame mainFrame) throws FileNotFoundException {
        setPrices();
        container = new JPanel();
        player = new Player(initGold);
        menuSlide = new ingameMenuSlide(mainFrame,this);
    }

    private void initTiles(MainFrame mainFrame) throws IOException {
        container.setLayout(grid);
        menuSlide.setVisible(true);
        for(int i = 0;i < gamefields.length; i++){
            gamefields[i] = new baseBuilding(player, mainFrame);
            container.add(gamefields[i]);
        }

        mainFrame.mainPanel.add(container);
        Game.refresh();
    }

    public void newGame(MainFrame mainFrame){
        try {
            player.setGold(initGold);
            mainFrame.mainPanel.removeAll();
            player.initPlayersInventory();
            initTiles(mainFrame);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void continuePreviousGame(MainFrame mainFrame){
        try {
            initTiles(mainFrame);
            loadGame(mainFrame);
            Game.refresh();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void loadGame(MainFrame mainFrame) throws IOException {
        FileReader reader = new FileReader(new File("").getAbsolutePath().concat("/resources/game.json"));

        toSave save = JsonMaker.getGson().fromJson(reader,toSave.class);
        player = save.player;
        gamefields = save.buildings;

        reader.close();
    }

    public long getInitGold() {
        return initGold;
    }

    public  void setPrices() throws FileNotFoundException {
        prices.clear();
        Gson gson =  new Gson();
        final Type mapType = new TypeToken<HashMap<String, Integer>>(){}.getType();
        prices = gson.fromJson( new FileReader(new File("").getAbsolutePath().concat("/resources/prices.json")), mapType);
    }

    public void save() throws IOException {
        toSave save = new toSave(player,gamefields);
        FileWriter fileWriter = new FileWriter(new File("").getAbsolutePath().concat("/resources/game.json"));
        JsonMaker.getGson().toJson(save, fileWriter);


        fileWriter.close();
    }

    public static void refresh(){
        container.removeAll();
        for (baseBuilding item : gamefields){
            container.add(item);
        }
        container.updateUI();

    }

    private  static class toSave{
        @Expose
        public Player player;
        @Expose
        public baseBuilding[] buildings;

        public toSave(Player player,baseBuilding[] buildings){
            this.buildings = buildings;
            this.player = player;
        }
    }

}
