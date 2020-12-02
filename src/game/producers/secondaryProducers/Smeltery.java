package game.producers.secondaryProducers;

import java.io.IOException;

public class Smeltery  extends secondaryProducer {
    public Smeltery() throws IOException {
        super("../../resources/smeltery.jpg");
    }

    @Override
    public void run() {
        try {
            super.produce("Iron Ore","Iron Ingot");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
