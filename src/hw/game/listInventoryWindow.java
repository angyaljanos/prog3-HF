package hw.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashMap;

public class listInventoryWindow extends JFrame {
    private static boolean isOpen = false;
    private JPanel container = new JPanel();
    private JScrollPane scrollPane = new JScrollPane(container);

    public listInventoryWindow() {
        if(!isOpen) {
            setTitle("Inventory");
            initWindow();
        }
    }
     private void initWindow(){
        setResizable(false);
        setSize(new Dimension(180,300));
        addWindowListener(new exitListener());
        add(scrollPane);
    }

    private void addValues(HashMap<String,Integer> map){
        JPanel content = new JPanel();
        content.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        int lineCnt = 0;
        for (String key : map.keySet()) {
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.gridy = lineCnt;
            content.add(new Label(key), constraints);
            content.add(new Label(String.valueOf(map.get(key))), constraints);

            lineCnt++;
        }
        container.add(content);
    }

    public void showInventory(HashMap<String,Integer> inventory){
        container.removeAll();
        addValues(inventory);
        setVisible(true);
        isOpen = true;

        (new Timer(500, actionEvent -> {
            container.removeAll();
            addValues(inventory);
            container.updateUI();
        })).start();
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
