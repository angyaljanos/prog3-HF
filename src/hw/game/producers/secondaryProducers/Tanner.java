package hw.game.producers.secondaryProducers;

import hw.game.Player;
import hw.MainFrame;

import java.io.IOException;

public class Tanner extends secondaryProducer {
    public Tanner(Player player, MainFrame mainFrame) throws IOException {
        super("tanner.jpg", player, mainFrame);
        name = "Tanner";
        cost = 5;
    }

    @Override
    public void run() {
        try {
            super.produce("Leather","Leather Clothing");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected String getBaseName() {
        return "Tanner";
    }
}
