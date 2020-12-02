package game;

import javax.swing.*;
import java.awt.*;

public class buildingPropertyWindow extends JFrame {
    private JPanel container;
    private JLabel nameLabel;
    private JLabel coolDownLabel;
    private JLabel productionLabel;
    private GridLayout grid = new GridLayout(0,1);

    public buildingPropertyWindow(baseBuilding building){
        setResizable(false);
        setSize(new Dimension(50,50));
        setUndecorated(true);

        nameLabel = new JLabel(building.getName());
        container.add(nameLabel);

        coolDownLabel = new JLabel("Cooldown:" + building.getCoolDownMs());
        container.add(coolDownLabel);

        productionLabel = new JLabel("Current quantity:" + building.getQuantity());
        container.add(productionLabel);

        container.setLayout(grid);
        add(container);
        container.setSize(container.getParent().getSize());
    }

    public void showProperties(){
        setVisible(true);
    }
}
