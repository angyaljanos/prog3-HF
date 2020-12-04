package game;

import com.google.gson.Gson;
import hw.MainFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Game {
    public static HashMap prices = new HashMap<String,Integer>();
    private static ingameMenuSlide menuSlide;
    private static JPanel container;
    private static baseBuilding[] gamefields = new baseBuilding[16];;
    private static Player player;
    private static GridLayout grid = new GridLayout(4,4);

    public Game(MainFrame mainFrame) throws FileNotFoundException {
        container = new JPanel();
        player = new Player();
        menuSlide = new ingameMenuSlide(mainFrame,player,prices);

        setPrices();
    }

    private static void initTiles() throws IOException {
        container.setLayout(grid);
        menuSlide.setVisible(true);
        for(baseBuilding item: gamefields){
            item = new baseBuilding();
            container.add(item);
        }
        MainFrame.mainPanel.add(container);
        //container.getComponentAt()
    }

    public static void newGame(Player player){
        try {
            Player.gold = 0;

            initTiles();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void continuePreviousGame(MainFrame mainFrame){
        try {
            initTiles();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public  void setPrices() throws FileNotFoundException {
        prices.clear();
        Gson gson = new Gson();
        //prices = gson.fromJson(new FileReader("..\\resources\\prices.json"),prices.getClass());
    }

    public static void save(){
        Gson gson = new Gson();
    }


    private class buyBuildingListener implements MouseListener{
        buildingShopFrame buildingShopFrame;

        private buyBuildingListener() throws IOException {
            buildingShopFrame = new buildingShopFrame();
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
