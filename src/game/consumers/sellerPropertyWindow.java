package game.consumers;

import game.*;
import game.baseBuilding;
import game.buildingPropertyWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class sellerPropertyWindow extends buildingPropertyWindow{

    private JButton upgradeButton = new JButton("Upgrade");
    private JButton sellButton = new JButton("Sell");



    public sellerPropertyWindow(baseBuilding building) {
        super(building);

        setUndecorated(false);
        setSize(new Dimension(200, 150));

        upgradeButton.addActionListener(new upgradeConsumer(building));
        container.add(upgradeButton);
        sellButton.addActionListener(new sellConsumer(building));
        container.add(sellButton);

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

    @Override
    public void showProperties(){
        super.showProperties();
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
            baseBuilding.isWindowOpen = false;
        }
    }
}
