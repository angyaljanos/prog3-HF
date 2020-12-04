package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class viewGoldFrame extends JFrame {
    private JPanel container = new JPanel();
    private JLabel goldLabel;
    public viewGoldFrame(){
        goldLabel = new JLabel(Player.gold+"");
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

    public void update(){
        goldLabel.setText("Gold:" + Player.gold);
        super.update(this.getGraphics());
    }

}
