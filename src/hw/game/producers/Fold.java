package hw.game.producers;

import hw.game.Player;
import hw.MainFrame;

import java.io.IOException;

public class Fold extends Producer{
    public Fold(Player player, MainFrame mainFrame) throws IOException {
        super("fold.jpg", player, mainFrame);
        name = "Fold";
        cost = 2;
    }

    @Override
    public void run() {
        try {
            super.produce("Leather");
            super.produce("Meat");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected String getBaseName() {
        return "Fold";
    }
}

