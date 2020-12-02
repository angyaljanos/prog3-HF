package game.producers.secondaryProducers;

import java.io.IOException;

public class Tanner extends secondaryProducer {
    public Tanner(String path) throws IOException {
        super("../../resources/tanner.jpg");
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
