package hw.game.producers;

import hw.game.Player;
import hw.MainFrame;

import java.io.IOException;

public class Quarry extends Producer{
    public Quarry(Player player, MainFrame mainFrame) throws IOException {
        super("quary.jpg", player, mainFrame);
        name = "Quarry";
        cost = 1;
    }

    @Override
    public void run() {
        try {
            super.produce("Stone");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected String getBaseName() {
        return "Quarry";
    }
}
