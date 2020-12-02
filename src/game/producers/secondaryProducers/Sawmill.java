package game.producers.secondaryProducers;

import java.io.IOException;

public class Sawmill extends secondaryProducer {
    public Sawmill() throws IOException {
        super("../../resources/sawmill.jpg");
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
