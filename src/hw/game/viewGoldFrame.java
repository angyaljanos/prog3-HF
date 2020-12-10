package hw.game;

import javax.swing.*;
import java.awt.*;

public class viewGoldFrame extends JFrame {
    private JPanel container = new JPanel();
    private JLabel goldLabel;
    public viewGoldFrame(Player player){
        goldLabel = new JLabel(String.valueOf(player.getGold()));
        container.setLayout(new GridLayout(0,1));

        container.add(goldLabel);
        add(container);

        setUndecorated(true);
    }

    public void showFrame(){
        setSize(new Dimension(100,40));
        Point p = MouseInfo.getPointerInfo().getLocation();
        setLocation(p.x,p.y);
        setVisible(true);
    }

    public void update(Player player){
        goldLabel.setText("Gold:" + player.getGold());
        super.update(this.getGraphics());
    }

}
