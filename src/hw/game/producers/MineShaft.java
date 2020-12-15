package hw.game.producers;

import hw.game.Player;
import hw.MainFrame;

import java.io.IOException;

public class MineShaft extends Producer{
    public MineShaft(Player player, MainFrame mainFrame) throws IOException {
        super("mineshaft.jpg", player, mainFrame);
        name = "Mine Shaft";
        cost = 3;
    }

    @Override
    public void run() {
        try {
            super.produce("Iron Ore");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected String getBaseName() {
        return "MineShaft";
    }
}
