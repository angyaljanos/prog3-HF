package game.producers;

import java.io.IOException;

public class Fold extends Producer{
    public Fold() throws IOException {
        super("../../resources/fold.jpg");
    }

    @Override
    public void run() {
        try {
            super.produce("Leather");
            super.produce("Meat");
            Thread.sleep(coolDownMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
