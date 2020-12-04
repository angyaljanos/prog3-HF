package game;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Iterator;

public class listItemsWindow extends JFrame {
    private HashMap<String,Integer> map;
    private JPanel container = new JPanel();

    public listItemsWindow(HashMap<String, Integer> map) {
        this.map = map;
        startWindow();
    }
     public void startWindow(){
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(150,150));

         addMapValuesToWindow();

        setVisible(true);
    }

    private void addMapValuesToWindow(){
        container.setLayout(new GridLayout(0,2));

        for(String key : map.keySet()){
            container.add(
                new Panel().add(new Label(key))
            );
            container.add(
                    new Panel().add(new Label(map.get(key).toString()))
            );
        }
    }
}
