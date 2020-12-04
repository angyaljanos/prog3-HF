package game.producers.secondaryProducers;

import game.Player;

import java.io.IOException;

public class Bakery extends secondaryProducer {
    public Bakery() throws IOException {
        super("../../resources/bakery.jpg");
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
