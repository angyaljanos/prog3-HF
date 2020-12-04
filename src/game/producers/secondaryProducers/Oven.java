package game.producers.secondaryProducers;

import game.Player;

import java.io.IOException;

public class Oven extends secondaryProducer {
    public Oven() throws IOException {
        super("../../resources/oven.jpg");
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
