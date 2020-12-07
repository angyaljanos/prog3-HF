package game.producers.secondaryProducers;

import game.Player;
import hw.MainFrame;

import java.io.IOException;

public class StoneCutter extends secondaryProducer{
    public StoneCutter(Player player, MainFrame mainFrame) throws IOException {
        super("stonecutter.jpg", player, mainFrame);
    }

    @Override
    public void run() {
        try {
            super.produce("Stone","Stone Brick");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected String getBaseName() {
        return "Stone Cutter ";
    }
}
