package game.producers.secondaryProducers;

import game.Player;

import java.io.IOException;

public class StoneCutter extends secondaryProducer{
    public StoneCutter(Player player) throws IOException {
        super("stonecutter.jpg", player);
        buildingName = "StoneCutter";
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
