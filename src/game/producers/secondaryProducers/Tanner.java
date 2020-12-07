package game.producers.secondaryProducers;

import game.Player;
import hw.MainFrame;

import java.io.IOException;

public class Tanner extends secondaryProducer {
    public Tanner(Player player,MainFrame mainFrame) throws IOException {
        super("tanner.jpg", player, mainFrame);
        buildingName = "Tanner";
    }

    @Override
    public void run() {
        try {
            super.produce("Leather","Leather Clothing");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
