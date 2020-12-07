package game.producers;

import game.Player;
import hw.MainFrame;

import java.io.IOException;

public class Woods extends Producer{
    public Woods(Player player, MainFrame mainFrame) throws IOException {
        super("woods.jpg", player, mainFrame);
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
