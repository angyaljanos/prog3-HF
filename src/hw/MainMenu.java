package hw;


import hw.game.Game;
import hw.game.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class MainMenu {
    private JPanel menuPanel = new JPanel();
    private JLabel title = new JLabel("Welcome to Producer-Consumer Game");
    private JButton continueButton = new JButton("Continue");
    private JButton newGameButton = new JButton("New Game");
    private JButton quitButton = new JButton("Exit");
    private BoxLayout layout;

    private Game game;

    public MainMenu(MainFrame mainFrame) throws FileNotFoundException {
        initComponents(mainFrame);
        game = new Game(mainFrame);
    }

    public void initComponents(MainFrame mainFrame){
        layout = new BoxLayout(menuPanel,BoxLayout.Y_AXIS);

        newGameButton.addActionListener(new newGameButtonListener(mainFrame));
        continueButton.addActionListener(new continueButtonListener(mainFrame));
        quitButton.addActionListener(new exitButtonListener(mainFrame));

        menuPanel.add(title);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Arial",Font.BOLD,30));

        menuPanel.add(Box.createRigidArea(new Dimension(0,20)));
        menuPanel.add(newGameButton);
        newGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        newGameButton.setFont(new Font("Arial",Font.BOLD,30));

        menuPanel.add(Box.createRigidArea(new Dimension(0,20)));
        menuPanel.add(continueButton);
        continueButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        continueButton.setFont(new Font("Arial",Font.BOLD,30));

        menuPanel.add(Box.createRigidArea(new Dimension(0,20)));
        menuPanel.add(quitButton);
        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        quitButton.setFont(new Font("Arial",Font.BOLD,30));

        menuPanel.setLayout(layout);
        mainFrame.mainPanel.add(menuPanel);
    }

    public void removeMenuComponents(MainFrame mainFrame){
        mainFrame.mainPanel.remove(menuPanel);
        mainFrame.mainPanel.setBackground(Color.white);//refreshing the main panel
    }

    private class newGameButtonListener implements ActionListener {
        private MainFrame mainFrame;
        private Player player;
        public newGameButtonListener(Player player){
            this.player = player;
        }

        public newGameButtonListener(MainFrame mainFrame){
            this.mainFrame = mainFrame;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            removeMenuComponents(mainFrame);
            game.newGame(mainFrame);
        }

    }
    private class continueButtonListener implements ActionListener {
        MainFrame mainFrame;

        public continueButtonListener(MainFrame mainFrame){
            this.mainFrame = mainFrame;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            game.continuePreviousGame(mainFrame);
            removeMenuComponents(mainFrame);
        }
    }
    private class exitButtonListener implements ActionListener {
        MainFrame frame;

        public exitButtonListener(MainFrame frame){
            this.frame = frame;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Hello vIITnám");
            frame.dispose();
        }
    }
}
