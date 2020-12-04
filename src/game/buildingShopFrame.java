package game;

import game.consumers.sellerMarket;
import game.producers.*;
import game.producers.secondaryProducers.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;

public class buildingShopFrame extends JFrame {
    private JPanel container = new JPanel();
    private JScrollPane scrollPane;
    private JLabel labels = new JLabel();
    private JButton buyButton = new JButton();

    private GridLayout grid = new GridLayout(0,2);

    public buildingShopFrame() throws IOException {
        getBuildingPrices();
        scrollPane = new JScrollPane(container);
        setSize(new Dimension(150,100));

        add(scrollPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void getBuildingPrices() throws IOException {
        Scanner sc = new Scanner("buildPrices.txt");
        while (sc.hasNext()){
            String[] line = sc.nextLine().split(":");

            for(int i = 0; i < line.length; i++){
                labels = new JLabel(line[0]);
                buyButton = new JButton(line[1]);

                container.add(labels);
                container.add(buyButton);
            }
        }

        sc.close();
    }

    public baseBuilding addNew(String name) throws IOException {
        baseBuilding temp;
        switch (name){
            case "Woods":
                temp = new Woods();
                break;
            case "Quarry":
                temp = new Quarry();
                break;
            case "Fold":
                temp = new Fold();
                break;
            case "Land":
                temp = new Land();
                break;
            case "Mine Shaft":
                temp = new MineShaft();
                break;
            case "Seller Market":
                temp = new sellerMarket();
                break;
            case "Saw Mill":
                temp = new Sawmill();
                break;
            case "Stone Cutter":
                temp = new StoneCutter();
                break;
            case "Bakery":
                temp = new Bakery();
                break;
            case "Oven":
                temp = new Oven();
                break;
            case "Smeltery":
                temp = new Smeltery();
                break;
            case "Tanner":
                temp = new Tanner();
                break;
            default:return null;
        }
        return temp;
    }

    private class buyBuildingListener implements ActionListener{
        Integer cost;
        String bname;
        public  buyBuildingListener(String buildingName, Integer costValue){
            this.cost = costValue;
            bname = buildingName;
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            try {
                if(Player.gold >= cost) {
                    Player.gold -= cost;
                    addNew(bname);
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
