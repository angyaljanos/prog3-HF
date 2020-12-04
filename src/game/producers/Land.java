package game.producers;

import game.Player;

import java.io.IOException;

public class Land extends Producer{
    public Land(Player player) throws IOException {
        super("land.jpg", player);
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
