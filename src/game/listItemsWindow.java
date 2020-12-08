package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashMap;

public class listItemsWindow extends JFrame {
    private static boolean isOpen = false;
    private HashMap<String,Integer> map;
    private JPanel container = new JPanel();
    private JScrollPane scrollPane = new JScrollPane(container);

    public listItemsWindow(HashMap<String, Integer> map) {
        if(!isOpen) {
            setTitle("Inventory");
            this.map = map;
            startWindow();
        }
    }
     public void startWindow(){

        setResizable(false);
        setSize(new Dimension(200,100));

        addWindowListener(new exitListener());

        add(scrollPane);
        addMapValuesToWindow();

        setVisible(true);
        isOpen = true;
    }

    private void addMapValuesToWindow(){
        JPanel content = new JPanel();
        content.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        if(map.isEmpty()){
            content.add(new JLabel("Your inventory is empty"));
        }
        else {
            int lineCnt = 0;
            for (String key : map.keySet()) {
                constraints.fill = GridBagConstraints.HORIZONTAL;
                constraints.gridy = lineCnt;
                content.add(new Label(key), constraints);
                content.add(new Label(String.valueOf(map.get(key))), constraints);

                lineCnt++;
            }
        }
        container.add(content);
    }
    
    
    private final class exitListener implements WindowListener{

        @Override
        public void windowClosing(WindowEvent windowEvent) {
            isOpen = false;
            dispose();
        }

        @Override
        public void windowOpened(WindowEvent windowEvent) {

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
    }
}
