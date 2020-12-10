package hw.game.producers.secondaryProducers;

import hw.game.Player;
import hw.MainFrame;

import java.io.IOException;

public class Sawmill extends secondaryProducer {
    public Sawmill(Player player, MainFrame mainFrame) throws IOException {
        super("sawmill.jpg", player, mainFrame);
        cost = 3;
    }

    @Override
    public void run() {
        try {
            super.produce("Wood","Planks");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected String getBaseName() {
        return "Sawmill";
    }
}
