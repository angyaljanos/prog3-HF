package hw.game.producers.secondaryProducers;

import hw.game.Player;
import hw.MainFrame;

import java.io.IOException;

public class Bakery extends secondaryProducer {
    public Bakery(Player player, MainFrame mainFrame) throws IOException {
        super("bakery.jpg", player, mainFrame);
        name = "Bakery";
        cost = 4;
    }

    @Override
    public void run() {
        try {
            super.produce("Grains","Bread");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected String getBaseName() {
        return "Bakery";
    }
}
