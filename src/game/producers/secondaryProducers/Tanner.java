package game.producers.secondaryProducers;

import game.Player;

import java.io.IOException;

public class Tanner extends secondaryProducer {
    public Tanner(Player player) throws IOException {
        super("tanner.jpg", player);
        buildingName = "Tanner";
    }

    @Override
    public void run() {
        try {
            super.produce("Leather","Leather Clothing");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
