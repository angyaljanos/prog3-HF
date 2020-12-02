package game.producers;

import java.io.IOException;

public class Land extends Producer{
    public Land() throws IOException {
        super("../../resources/land.jpg");
    }

    @Override
    public void run() {
        try {
            super.produce("Grains");
            Thread.sleep(coolDownMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
