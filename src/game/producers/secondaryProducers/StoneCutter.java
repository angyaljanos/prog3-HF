package game.producers.secondaryProducers;

import java.io.IOException;

public class StoneCutter extends secondaryProducer{
    public StoneCutter() throws IOException {
        super("../../resources/stonecutter.jpg");
    }

    @Override
    public void run() {
        try {
            super.produce("Stone","Stone Brick");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
