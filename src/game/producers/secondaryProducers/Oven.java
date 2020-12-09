package game.producers.secondaryProducers;

import game.Player;
import hw.MainFrame;

import java.io.IOException;

public class Oven extends secondaryProducer {
    public Oven(Player player, MainFrame mainFrame) throws IOException {
        super("oven.jpg", player,mainFrame);
        cost = 5;
    }

    @Override
    public void run() {
        try {
            super.produce("Meat","Roast");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected String getBaseName() {
        return "Oven";
    }
}
