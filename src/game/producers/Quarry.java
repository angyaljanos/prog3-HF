package game.producers;

import java.io.IOException;

public class Quarry extends Producer{
    public Quarry() throws IOException {
        super("../../resources/quary.jpg");
    }

    @Override
    public void run() {
        try {
            super.produce("Stone");
            Thread.sleep(coolDownMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
