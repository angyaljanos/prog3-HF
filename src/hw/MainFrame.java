package hw;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public JPanel mainPanel = new JPanel();
    // Felépítjük az ablakot
    public MainFrame(){
        super("Consumer-Producer Game");
        super.frameInit();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 800));
        setResizable(false);

        //A képernyő közepére helyezzük az ablakot
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((int)(screenSize.getWidth()/2 - this.getWidth()/2), (int)(screenSize.getHeight()/2 - this.getHeight()/2));
        /*asdasd

        mainPanel.add(new JButton("Heey Im here"));
        */
        this.add(mainPanel);

        MainMenu m = new MainMenu(this);
    }
}
