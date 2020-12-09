package game.producers;

import game.Player;
import hw.MainFrame;

import java.io.IOException;

public class Quarry extends Producer{
    public Quarry(Player player, MainFrame mainFrame) throws IOException {
        super("quary.jpg", player, mainFrame);
        cost = 1;
    }

    @Override
    public void run() {
        try {
            super.produce("Stone");
            Thread.sleep(coolDownMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected String getBaseName() {
        return "Quarry";
    }
}
