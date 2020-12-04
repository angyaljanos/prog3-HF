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

    }

    public void showProperties(){
        setVisible(true);
        Point tmp = MouseInfo.getPointerInfo().getLocation();
        Dimension dim = new Dimension(tmp.x, tmp.y);
        //this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setLocation(dim.width, dim.height);
    }
}
