package game.producers.secondaryProducers;

import game.Player;

import java.io.IOException;

public class Sawmill extends secondaryProducer {
    public Sawmill( Player player) throws IOException {
        super("sawmill.jpg", player);
        buildingName = "Sawmill";
    }

    @Override
    public void run() {
        try {
            super.produce("Wood","Planks");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
