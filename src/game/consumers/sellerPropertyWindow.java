package game.consumers;

import game.*;
import game.baseBuilding;
import game.buildingPropertyWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class sellerPropertyWindow extends buildingPropertyWindow{

    private JButton upgradeButton = new JButton("Upgrade");
    private JButton sellButton = new JButton("Sell");

    public static boolean isOpen = false;

    public sellerPropertyWindow(baseBuilding building) {
        super(building);

        setUndecorated(false);
        setSize(new Dimension(200, 150));

        upgradeButton.addActionListener(new upgradeConsumer(building));
        container.add(upgradeButton);
        sellButton.addActionListener(new sellConsumer(building));
        container.add(sellButton);

    }

    @Override
    public void showProperties(){
        super.showProperties();
        isOpen = true;
    }

    private static class upgradeConsumer implements ActionListener{
        baseBuilding base;
        public  upgradeConsumer(baseBuilding baseBuilding){
            base = baseBuilding;
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            base.addWorker();
        }
    }
    private class sellConsumer implements ActionListener{
        baseBuilding base;
        public  sellConsumer(baseBuilding baseBuilding){
            base = baseBuilding;
        }
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            try {
                base.getOwner().incrementGold(base.getCost());
                for (int i = 0; i < Game.gamefields.length; i++) {
                    if (Game.gamefields[i] == base) {
                        Game.gamefields[i] = new baseBuilding(base.getOwner(), base.getMainFrame());
                    }
                }
                Game.refresh();
                ingameMenuSlide.refresh(base.getOwner());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            dispose();
            isOpen = false;
        }
    }
}
