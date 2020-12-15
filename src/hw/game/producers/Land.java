package hw.game.producers;

import hw.game.Player;
import hw.MainFrame;

import java.io.IOException;

public class Land extends Producer{
    public Land(Player player, MainFrame mainFrame) throws IOException {
        super("land.jpg", player, mainFrame);
        name = "Land";
        cost = 1;
    }

    @Override
    public void run() {
        try {
            super.produce("Grains");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected String getBaseName() {
        return "Land";
    }
}
