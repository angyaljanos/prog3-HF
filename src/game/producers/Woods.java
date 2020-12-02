package game.producers;

import java.io.IOException;

public class Woods extends Producer{
    public Woods() throws IOException {
        super("../../resources/quary.jpg");
    }

    @Override
    public void run() {
        try {
            super.produce("Wood");
            Thread.sleep(coolDownMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
