package game.producers;

import game.Player;
import hw.MainFrame;

import java.io.IOException;

public class MineShaft extends Producer{
    public MineShaft(Player player, MainFrame mainFrame) throws IOException {
        super("mineshaft.jpg", player, mainFrame);;
    }

    @Override
    public void run() {
        try {
            super.produce("Iron Ore");
            Thread.sleep(coolDownMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected String getBaseName() {
        return "MineShaft";
    }
}
