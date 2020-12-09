package game.producers;

import game.Game;
import game.baseBuilding;
import game.buildingPropertyWindow;
import game.ingameMenuSlide;

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
        upgradeButton = new JButton("Upgragde -" + building.getCost());
        sellButton = new JButton("Sell +" + building.getCost());
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
        sellButton.addActionListener(new sellProducer(building));
        container.add(sellButton);
    }

    private void refreshButtonTexts(baseBuilding building){
        upgradeButton.setText("Upgragde -" + building.getCost());
        sellButton.setText("Sell +" + building.getCost());
    }

    @Override
    public void showProperties() {
        super.showProperties();
    }

    private class upgradeConsumer implements ActionListener {
        baseBuilding base;
        public  upgradeConsumer(baseBuilding baseBuilding){
            base = baseBuilding;
            refreshButtonTexts(baseBuilding);
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
                    base.addWorker();
        }
    }
    private class sellProducer implements ActionListener{
        baseBuilding base;
        public sellProducer(baseBuilding baseBuilding){
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

