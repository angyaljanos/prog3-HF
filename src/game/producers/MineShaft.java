package game.producers;

import game.Player;

import java.io.IOException;

public class MineShaft extends Producer{
    public MineShaft(Player player) throws IOException {
        super("mineshaft.jpg", player);
        buildingName = "MineShaft";
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
}
