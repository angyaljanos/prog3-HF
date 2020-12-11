package hw.game;

import hw.MainFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.HashMap;

public class ingameMenuSlide {
    private JMenuBar menuBar = new JMenuBar();

    private static JMenu storageMenu = new JMenu();
    private static JMenu gameFunctionsMenu = new JMenu();
    private static JMenu goldMenu = new JMenu();

    private final String[] gameFunctions = {"Save","New Game"};
    private final String[] storageFunctions = {"View", "Sell All"};

    private JMenuItem[] storageMenuItems = new JMenuItem[storageFunctions.length];
    private JMenuItem[] gameMenuItems = new JMenuItem[gameFunctions.length];

    public ingameMenuSlide(MainFrame mainFrame,Game game){
        initializeGameMenu(game, mainFrame);
        initializeStorageMenu(game.player, Game.prices);
        initializeGoldMenu(game.player);

        menuBar.setVisible(false);

        mainFrame.setJMenuBar(menuBar);
    }

    public void initializeStorageMenu(Player player,HashMap<String,Integer> pricelist){
        storageMenu.setText("Storage");
        for(int i = 0; i < storageFunctions.length; i++){
            storageMenuItems[i] = new JMenuItem(storageFunctions[i]);
            storageMenu.add(storageMenuItems[i]);
        }
        storageMenuItems[0].addActionListener(new viewStorage(player));
        storageMenuItems[1].addActionListener(new sellInventory(player,pricelist));
        menuBar.add(storageMenu);
    }

    public void initializeGameMenu(Game game,MainFrame mainFrame){
        gameFunctionsMenu.setText("Game");
        for(int i = 0; i < gameFunctions.length; i++){
            gameMenuItems[i] = new JMenuItem(gameFunctions[i]);
            gameFunctionsMenu.add(gameMenuItems[i]);
        }
        gameMenuItems[0].addActionListener(new gameSaverListener(game));
        gameMenuItems[1].addActionListener(new newGameListener(game,mainFrame));
        menuBar.add(gameFunctionsMenu);
    }

    public void initializeGoldMenu(Player player){
        goldMenu.setText("Gold: " + player.getGold());
        menuBar.add(goldMenu);
    }

    public void setVisible(boolean b){
        menuBar.setVisible(b);
    }

    private class gameSaverListener implements ActionListener{
        private Game game;

        public gameSaverListener(Game game) {
            this.game = game;
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            try {
                game.save();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private class newGameListener implements ActionListener{
        private Game currentGame;
        private MainFrame mainFrame;
        public newGameListener(Game game, MainFrame mainFrame){
            currentGame = game;
            this.mainFrame = mainFrame;
        }
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            currentGame.newGame(mainFrame);
        }
    }

    private class viewStorage implements ActionListener{
        private Player player;
        private final listInventoryWindow listWindow = new listInventoryWindow();
        public viewStorage(Player player){
            this.player = player;
        }
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            listWindow.showInventory(player.inventory);
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
            int value = 0;
            for(String key : player.inventory.keySet()){
                value += (int)player.inventory.get(key) * (int)prices.get(key);
            }
            player.incrementGold(value);
            refresh(player);
        }
    }

    public static  void refresh(Player player){
        goldMenu.setText("Gold: " + player.getGold());
    }
}
