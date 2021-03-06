package hw.game;

import hw.game.consumers.sellerMarket;
import hw.MainFrame;
import hw.game.producers.*;
import hw.game.producers.secondaryProducers.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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

    public void showShop() {
        setVisible(true);
    }
    
    public buildingShopFrame(baseBuilding base){
        super("Building Shop");
        newBuilding = base;
        getBuildingPrices();
        container.setLayout(grid);
        scrollPane = new JScrollPane(container);

        baseBuilding.isWindowOpen = true;

        setSize(new Dimension(250,100));

        add(scrollPane);
        setLocation(MouseInfo.getPointerInfo().getLocation());
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        setResizable(false);

        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent windowEvent) {

            }

            @Override
            public void windowClosing(WindowEvent windowEvent) {
                baseBuilding.isWindowOpen = false;
            }

            @Override
            public void windowClosed(WindowEvent windowEvent) {

            }

            @Override
            public void windowIconified(WindowEvent windowEvent) {

            }

            @Override
            public void windowDeiconified(WindowEvent windowEvent) {

            }

            @Override
            public void windowActivated(WindowEvent windowEvent) {

            }

            @Override
            public void windowDeactivated(WindowEvent windowEvent) {

            }
        });
    }

    public void setChoosedBuildingName(String choosedBuildingName) {
        this.choosedBuildingName = choosedBuildingName;
    }

    private void getBuildingPrices() {
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

    public void addNew(MainFrame mainFrame) throws IOException {
        baseBuilding tmp;
        switch (choosedBuildingName){
            case "Woods":
                tmp = new Woods(newBuilding.owner, mainFrame);
                break;
            case "Quarry":
                tmp = new Quarry(newBuilding.owner, mainFrame);
                break;
            case "Fold":
                tmp = new Fold(newBuilding.owner, mainFrame);
                break;
            case "Land":
                tmp = new Land(newBuilding.owner, mainFrame);
                break;
            case "Mine Shaft":
                tmp = new MineShaft(newBuilding.owner, mainFrame);
                break;
            case "Seller Market":
                tmp = new sellerMarket(newBuilding.owner, mainFrame);
                break;
            case "Saw Mill":
                tmp = new Sawmill(newBuilding.owner, mainFrame);
                break;
            case "Stone Cutter":
                tmp = new StoneCutter(newBuilding.owner, mainFrame);
                break;
            case "Bakery":
                tmp = new Bakery(newBuilding.owner, mainFrame);
                break;
            case "Oven":
                tmp = new Oven(newBuilding.owner, mainFrame);
                break;
            case "Smeltery":
                tmp = new Smeltery(newBuilding.owner, mainFrame);
                break;
            case "Tanner":
                tmp = new Tanner(newBuilding.owner, mainFrame);
                break;
            default:tmp = new baseBuilding(newBuilding.owner, mainFrame);
        }
        for (int i = 0; i < Game.gamefields.length; i++){
            if(Game.gamefields[i] == newBuilding){
                Game.gamefields[i] = tmp;
                Game.refresh();
            }
        }
        tmp.start();
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
                if(newBuilding.getOwner().getGold() >= buildCost) {
                    newBuilding.getOwner().decraseGold(buildCost);
                    choosedBuildingName = bname;

                    addNew(newBuilding.mainFrame);
                    ingameMenuSlide.refresh(newBuilding.getOwner());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                dispose();
                baseBuilding.isWindowOpen = false;
            }
        }
    }
}
