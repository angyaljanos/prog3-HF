package game.producers.secondaryProducers;

import game.Player;

import java.io.IOException;

public class Bakery extends secondaryProducer {
    public Bakery(Player player) throws IOException {
        super("bakery.jpg", player);
        buildingName = "Bakery";
    }

    @Override
    public void run() {
        try {
            super.produce("Grains","Bread");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
