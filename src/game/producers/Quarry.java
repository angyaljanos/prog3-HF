package game.producers;

import game.Player;

import java.io.IOException;

public class Quarry extends Producer{
    public Quarry(Player player) throws IOException {
        super("quary.jpg", player);
        buildingName = "Quarry";
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
}
