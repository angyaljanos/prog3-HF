package hw;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class MainFrame extends JFrame {
    public static JPanel mainPanel = new JPanel();
    public MainFrame() throws FileNotFoundException {
        super("Consumer-Producer Game");
        super.frameInit();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 800));
        setResizable(false);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((int)(screenSize.getWidth()/2 - this.getWidth()/2), (int)(screenSize.getHeight()/2 - this.getHeight()/2));
        this.add(mainPanel);

        MainMenu m = new MainMenu(this);
    }
}
