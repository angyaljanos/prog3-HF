package hw;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args){
        try {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
