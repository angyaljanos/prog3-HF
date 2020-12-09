package game.producers;

import game.Player;
import hw.MainFrame;

import java.io.IOException;

public class Fold extends Producer{
    public Fold(Player player, MainFrame mainFrame) throws IOException {
        super("fold.jpg", player, mainFrame);
        cost = 2;
    }

    @Override
    public void run() {
        try {
            super.produce("Leather");
            super.produce("Meat");
            Thread.sleep(coolDownMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected String getBaseName() {
        return "Fold";
    }
}

