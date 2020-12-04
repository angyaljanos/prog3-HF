package game;

import game.consumers.sellerMarket;
import game.producers.*;
import game.producers.secondaryProducers.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class buildingShopFrame extends JFrame {
    private JPanel container = new JPanel();
    private JScrollPane scrollPane;
    private JLabel labels = new JLabel();
    private JButton buyButton = new JButton();

    private GridLayout grid = new GridLayout(0,2);

    private String choosedBuildingName = "None";
    private baseBuilding newBuilding;
    private Player owner;

    public buildingShopFrame(baseBuilding base) throws IOException {
        super("Building Shop");
        newBuilding = base;
        owner = base.getOwner();
        getBuildingPrices();
        container.setLayout(grid);
        scrollPane = new JScrollPane(container);

        setSize(new Dimension(250,100));

        add(scrollPane);
        setLocation(MouseInfo.getPointerInfo().getLocation());
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void getBuildingPrices() throws IOException {
        Scanner sc = new Scanner(Objects.requireNonNull(baseBuilding.class.getClassLoader().getResourceAsStream("buildingPrices.txt")));
        while (sc.hasNext()){
            String[] line = sc.nextLine().split(":");

            for(int i = 0; i < line.length; i++){
                labels = new JLabel(line[0]);
                buyButton = new JButton(line[1]);
            }
            buyButton.addActionListener(new getBuildingNameListener(line[0],Long.parseLong(line[1])));
            container.add(labels);
            container.add(buyButton);
        }

        sc.close();
    }

    public void addNew() throws IOException {

        switch (choosedBuildingName){
            case "Woods":
                newBuilding = new Woods(newBuilding.owner);
                break;
            case "Quarry":
                newBuilding = new Quarry(newBuilding.owner);
                break;
            case "Fold":
                newBuilding = new Fold(newBuilding.owner);
                break;
            case "Land":
                newBuilding = new Land(newBuilding.owner);
                break;
            case "Mine Shaft":
                newBuilding = new MineShaft(newBuilding.owner);
                break;
            case "Seller Market":
                newBuilding = new sellerMarket(newBuilding.owner);
                break;
            case "Saw Mill":
                newBuilding = new Sawmill(newBuilding.owner);
                break;
            case "Stone Cutter":
                newBuilding = new StoneCutter(newBuilding.owner);
                break;
            case "Bakery":
                newBuilding = new Bakery(newBuilding.owner);
                break;
            case "Oven":
                newBuilding = new Oven(newBuilding.owner);
                break;
            case "Smeltery":
                newBuilding = new Smeltery(newBuilding.owner);
                break;
            case "Tanner":
                newBuilding = new Tanner(newBuilding.owner);
                break;
            default:newBuilding = new baseBuilding(newBuilding.owner);
        }
        new Thread((Runnable)newBuilding).start();
    }

    private class getBuildingNameListener implements ActionListener{
        long buildCost;
        String bname;
        public  getBuildingNameListener(String buildingName,long cost){
            bname = buildingName;
            buildCost = cost;
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            try {
                if(owner.getGold() >= buildCost) {
                    owner.decraseGold(buildCost);
                    choosedBuildingName = bname;

                    addNew();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                dispose();
            }
        }
    }
}
