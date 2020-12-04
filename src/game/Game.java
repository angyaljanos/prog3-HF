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
import java.util.Objects;
import java.util.Scanner;

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

    private void initTiles() throws IOException {
        container.setLayout(grid);
        menuSlide.setVisible(true);
        for(baseBuilding item: gamefields){
            item = new baseBuilding(player);
            container.add(item);
        }
        MainFrame.mainPanel.add(container);
        //container.getComponentAt()
    }

    public void newGame(){
        try {
            player.setGold(2);
            initTiles();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void continuePreviousGame(MainFrame mainFrame){
        try {
            initTiles();
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


    private class buyBuildingListener implements MouseListener{
        buildingShopFrame buildingShopFrame;

        private buyBuildingListener() throws IOException {
            buildingShopFrame = new buildingShopFrame((baseBuilding)container.getComponentAt(MouseInfo.getPointerInfo().getLocation()));
        }

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            Point pnt = MouseInfo.getPointerInfo().getLocation();
            container.getComponentAt(pnt);
        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {

        }
    }
}
