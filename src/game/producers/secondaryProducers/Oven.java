package game.producers.secondaryProducers;

import java.io.IOException;

public class Oven extends secondaryProducer {
    public Oven() throws IOException {
        super("../../resources/oven.jpg");
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
