package hw.game.producers;

import hw.game.Game;
import hw.game.baseBuilding;
import hw.game.buildingPropertyWindow;
import hw.game.ingameMenuSlide;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class producerPropertyWindow extends buildingPropertyWindow {

    private JButton upgradeButton;
    private JButton sellButton;

    public producerPropertyWindow(baseBuilding building) {
        super(building);
        upgradeButton = new JButton("Upgragde");
        sellButton = new JButton("Sell");
        initFrame(building);

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

    private void initFrame(baseBuilding building) {
        setUndecorated(false);
        setTitle("Info");
        setSize(new Dimension(220, 200));


        upgradeButton.addActionListener(new upgradeConsumer(building));
        container.add(upgradeButton);
        sellButton.addActionListener(new sellProducerListener(building));
        container.add(sellButton);
    }

    public sellProducerListener createrSellProducerListener(baseBuilding base){
        return new sellProducerListener(base);
    }

    @Override
    public void showProperties() {
        super.showProperties();
    }

    private class upgradeConsumer implements ActionListener {
        baseBuilding base;
        public  upgradeConsumer(baseBuilding baseBuilding){
            base = baseBuilding;
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
                    base.addWorker();
        }
    }
    public class sellProducerListener implements ActionListener{
        baseBuilding base;
        public sellProducerListener(baseBuilding baseBuilding){
                    base = baseBuilding;
                }
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            sell();
        }
        public void sell(){
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

