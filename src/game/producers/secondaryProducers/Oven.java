package game.producers.secondaryProducers;

import game.Player;

import java.io.IOException;

public class Oven extends secondaryProducer {
    public Oven(Player player) throws IOException {
        super("oven.jpg", player);
        buildingName = "Oven";
    }

    @Override
    public void run() {
        try {
            super.produce("Meat","Roast");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
