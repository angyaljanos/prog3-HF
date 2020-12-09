package game;

import game.consumers.sellerPropertyWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class buildingPropertyWindow extends JFrame {

    protected JPanel container;
    protected JLabel nameLabel;
    protected JLabel coolDownLabel;
    protected JLabel productionLabel;
    protected GridLayout grid = new GridLayout(0,1);

    public buildingPropertyWindow(baseBuilding building){
        setTitle(building.getBuildingName());
        setResizable(false);
        setSize(new Dimension(150,70));
        setUndecorated(true);

        container = new JPanel();

        nameLabel = new JLabel(building.getBuildingName());
        container.add(nameLabel);

        coolDownLabel = new JLabel("Cooldown:" + building.getCoolDownMs());
        container.add(coolDownLabel);

        productionLabel = new JLabel(building.getQuantity()+" item/sec");
        container.add(productionLabel);

        container.setLayout(grid);
        add(container);
        container.setSize(container.getParent().getSize());

        (new Timer(20, actionEvent -> {
            nameLabel.setText(building.getBuildingName());
            coolDownLabel.setText("Cooldown:" + building.getCoolDownMs());
            productionLabel.setText(building.getQuantity()+" item/sec");
        })).start();
    }

    public void showProperties(){
        if(!baseBuilding.isWindowOpen) {

            setVisible(true);
            Point tmp = MouseInfo.getPointerInfo().getLocation();
            this.setLocation(tmp.x, tmp.y);
        }
    }
}
