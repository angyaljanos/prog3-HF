package game;

import hw.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class nameInsertForm {
    private JFrame formFrame = new JFrame();
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel("Please Enter Your Name");
    private JTextField input = new JTextField(20);
    private JButton submitButton = new JButton("Submit");
    private GridLayout grid = new GridLayout(2,1);

    private String name;

    public nameInsertForm(){
        panel.add(label);
        panel.add(input);
        submitButton.addActionListener(e ->{
            name = input.getText();
            this.formFrame.dispose();
        });
        panel.add(submitButton);

        formFrame.add(panel);
        formFrame.setMinimumSize(new Dimension(400,150));
        formFrame.setLayout(grid);
        formFrame.setResizable(false);
        formFrame.setVisible(true);
    }

    public String getName(){
        return name;
    }
}
