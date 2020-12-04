package game.producers;

import game.Player;

import java.io.IOException;

public class Woods extends Producer{
    public Woods(Player player) throws IOException {
        super("quary.jpg", player);
        buildingName = "Woods";
    }

    @Override
    public void run() {
        try {
            super.produce("Wood");
            Thread.sleep(coolDownMs);
            System.out.println("+1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
