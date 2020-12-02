package game.producers.secondaryProducers;

import java.io.IOException;

public class Bakery extends secondaryProducer {
    public Bakery() throws IOException {
        super("../../resources/bakery.jpg");
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
