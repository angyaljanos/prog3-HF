package game;

import javax.swing.*;
import java.awt.*;

public class nameInsertForm {
    private JFrame frame = new JFrame("");
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel("Please Enter Your Name");
    private JTextField input = new JTextField(20);
    private JButton submitButton = new JButton("Submit");
    private GridBagLayout grid = new GridBagLayout();

    private String name;

    //label
    //textfield submitbutton


    public nameInsertForm(){
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.anchor = GridBagConstraints.HORIZONTAL;
        constraints.gridx = constraints.gridy = 0;
        panel.add(label,constraints);

        constraints.anchor = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;constraints.gridy = 1;
        panel.add(input,constraints);

        constraints.anchor = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;constraints.gridy = 1;
        panel.add(submitButton,constraints);

        frame.setMinimumSize(new Dimension(400,200));
        frame.add(panel);
        frame.setLayout(grid);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public String getPlayerName(){
        return name;
    }
}
