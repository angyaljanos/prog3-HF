package hw;

import game.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu {

    private static final JPanel menuPanel = new JPanel();
    private static final JLabel title = new JLabel("Welcome to Profucer-Cunsumer Game");
    private static final JButton continueButton = new JButton("Continue");
    private static final JButton newGameButton = new JButton("New Game");
    private static final JButton quitButton = new JButton("Exit");

    private GroupLayout layout;

    public MainMenu(MainFrame mainFrame){
        layout = new GroupLayout(mainFrame);
        layout.setAutoCreateGaps(true);

        menuPanel.setBackground(Color.CYAN);

        newGameButton.addActionListener(new newGameButtonListener(mainFrame));
        continueButton.addActionListener(new continueButtonListener(mainFrame));
        quitButton.addActionListener(new exitButtonListener(mainFrame));

        menuPanel.add(title);
        menuPanel.add(newGameButton);
        menuPanel.add(continueButton);
        menuPanel.add(quitButton);

        mainFrame.mainPanel.add(menuPanel);
    }

    public static class newGameButtonListener implements ActionListener {
        MainFrame mainFrame;

        public newGameButtonListener(MainFrame mainFrame){
            this.mainFrame = mainFrame;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            removeMenuComponents(mainFrame);
        }
        public void removeMenuComponents(MainFrame mainFrame){
            mainFrame.mainPanel.remove(menuPanel);
            mainFrame.mainPanel.setBackground(Color.white);//refreshing the main panel
            nameInsertForm f = new nameInsertForm();
        }
    }
    public static class continueButtonListener implements ActionListener {
        MainFrame mainFrame;

        public continueButtonListener(MainFrame mainFrame){
            this.mainFrame = mainFrame;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            removeMenuComponents(mainFrame);
        }
        public void removeMenuComponents(MainFrame mainFrame){
            mainFrame.mainPanel.remove(menuPanel);
            mainFrame.mainPanel.setBackground(Color.white);
        }
    }
    public static class exitButtonListener implements ActionListener {
        MainFrame frame;

        public exitButtonListener(MainFrame frame){
            this.frame = frame;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
        }

    }
}
