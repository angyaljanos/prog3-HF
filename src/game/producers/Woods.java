package game.producers;

import game.Player;

import java.io.IOException;

public class Woods extends Producer{
    public Woods() throws IOException {
        super("../../resources/quary.jpg");
        buildingName = "Woods";
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
