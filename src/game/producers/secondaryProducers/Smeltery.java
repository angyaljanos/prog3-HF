package game.producers.secondaryProducers;

import game.Player;
import hw.MainFrame;

import java.io.IOException;

public class Smeltery  extends secondaryProducer {
    public Smeltery(Player player, MainFrame mainFrame) throws IOException {
        super("smeltery.jpg", player, mainFrame);
        buildingName = "Smeltery";
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
