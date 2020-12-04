package game.producers;

import game.Player;

import java.io.IOException;

public class MineShaft extends Producer{
    public MineShaft() throws IOException {
        super("../../resources/mineshaft.jpg");
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
