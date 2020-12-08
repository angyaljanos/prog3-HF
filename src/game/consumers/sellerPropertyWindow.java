package game.consumers;

import game.baseBuilding;
import game.buildingPropertyWindow;

import javax.swing.*;

public class sellerPropertyWindow extends  buildingPropertyWindow{

    private JButton upgradeButton = new JButton("Upgrade");
    private JButton sellButton = new JButton("Sell");

    public sellerPropertyWindow(baseBuilding building) {
        super(building);
        setUndecorated(false);


    }

    public void showPoerties(){
        buildingPropertyWindow.isOpen = true;
        super.showProperties();
    }
}
