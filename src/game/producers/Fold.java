package game.producers;

import game.Player;

import java.io.IOException;

public class Fold extends Producer{
    public Fold(Player player) throws IOException {
        super("fold.jpg", player);
        buildingName = "Fold";
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
}
