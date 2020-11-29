package game;

import hw.MainFrame;
import javax.swing.*;

public class ingameMenuSlide {
    private JMenuBar menuBar = new JMenuBar();
    private JMenu storageMenu;
    private JMenu profileMenu;
    private JMenuItem[] storageFunctions;
    private JMenuItem[] playerFunctions;
    private String[] gameFunctionLabels = {"Storage", "View", "Sell All"};
    private String[] profileFunctionLabels = {"Save"};
    public ingameMenuSlide(MainFrame mainFrame,PlayerData playerData){
        storageFunctions = new JMenuItem[gameFunctionLabels.length];
        playerFunctions = new JMenuItem[profileFunctionLabels.length];

        storageMenu.setText("Storage");
        for(int i = 0; i < gameFunctionLabels.length; i++){
            storageFunctions[i] = new JMenuItem(gameFunctionLabels[i]);
            storageMenu.add( storageFunctions[i]);
        }

        profileMenu.setText(playerData.getName());
        for(int i = 0; i < profileFunctionLabels.length; i++){
            playerFunctions[i] = new JMenuItem(profileFunctionLabels[i]);
            profileMenu.add( playerFunctions[i]);
        }

        menuBar.add(profileMenu);
        menuBar.add(storageMenu);
        mainFrame.setJMenuBar(menuBar);
    }


    //Listenerek
    //Undone
}
