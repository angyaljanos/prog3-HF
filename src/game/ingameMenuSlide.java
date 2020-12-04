package game;

import hw.MainFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

public class ingameMenuSlide {
    private JMenuBar menuBar = new JMenuBar();

    private JMenu storageMenu = new JMenu();
    private JMenu gameFunctionsMenu = new JMenu();
    private JMenu goldMenu = new JMenu();

    private final String[] gameFunctions = {"Save","New Game"};
    private final String[] storageFunctions = {"View", "Sell All"};

    private JMenuItem[] storageMenuItems = new JMenuItem[storageFunctions.length];
    private JMenuItem[] gameMenuItems = new JMenuItem[gameFunctions.length];

    public ingameMenuSlide(MainFrame mainFrame,Player player,HashMap<String,Integer> priceList){
        initializeGameMenu(player,priceList);
        initializeStorageMenu(player);
        initializeGoldMenu(player);

        menuBar.setVisible(false);

        mainFrame.setJMenuBar(menuBar);
    }

    public void initializeStorageMenu(Player player){
        storageMenu.setText("Storage");
        for(int i = 0; i < storageFunctions.length; i++){
            storageMenuItems[i] = new JMenuItem(storageFunctions[i]);
            storageMenu.add(storageMenuItems[i]);
        }
        storageMenuItems[0].addActionListener(new gameSaverListener());
        storageMenuItems[1].addActionListener(new newGameListener(player));
        menuBar.add(storageMenu);
    }

    public void initializeGameMenu(Player player,HashMap<String,Integer> priceList){
        gameFunctionsMenu.setText("Game");
        for(int i = 0; i < gameFunctions.length; i++){
            gameMenuItems[i] = new JMenuItem(gameFunctions[i]);
            gameFunctionsMenu.add(gameMenuItems[i]);
        }
        gameMenuItems[0].addActionListener(new viewStorage(player));
        gameMenuItems[1].addActionListener(new sellInventory(player,priceList));
        menuBar.add(gameFunctionsMenu);
    }

    public void initializeGoldMenu(Player player){
        goldMenu.setText("Gold");
        goldMenu.addMouseListener(new hoverMouseListener());
        menuBar.add(goldMenu);
    }

    public void setVisible(boolean b){
        menuBar.setVisible(b);
    }

    private class gameSaverListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            Game.save();
        }
    }
    private class newGameListener implements ActionListener{
        private Player player;
        public newGameListener(Player player){
            this.player = player;
        }
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            Game.newGame(player);
        }
    }

    private class viewStorage implements ActionListener{
        private Player player;
        public viewStorage(Player player){
            this.player = player;
        }
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            listItemsWindow l = new listItemsWindow(Player.inventory);
        }
    }
    private class sellInventory implements ActionListener{
        private Player player;
        private HashMap<String, Integer> prices;
        public sellInventory(Player player, HashMap<String,Integer> priceList){
            this.player = player;
            this.prices = priceList;
        }
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            for(String key : Player.inventory.keySet()){
                Player.gold += Player.inventory.get(key) * prices.get(key);
            }
        }
    }

    private class hoverMouseListener implements MouseListener {
        private viewGoldFrame goldFrame;

        public hoverMouseListener() {
            this.goldFrame = new viewGoldFrame();
        }

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {

        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {
            goldFrame.update();
            goldFrame.showFrame();
        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {
            goldFrame.dispose();
        }
    }
}
