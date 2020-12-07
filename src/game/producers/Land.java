package game.producers;

import game.Player;
import hw.MainFrame;

import java.io.IOException;

public class Land extends Producer{
    public Land(Player player, MainFrame mainFrame) throws IOException {
        super("land.jpg", player, mainFrame);
        buildingName = "Land";
    }

    @Override
    public void run() {
        try {
            super.produce("Grains");
            Thread.sleep(coolDownMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
