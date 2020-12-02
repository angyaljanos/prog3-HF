package game.producers;

import java.io.IOException;

public class MineShaft extends Producer{
    public MineShaft() throws IOException {
        super("../../resources/mineshaft.jpg");
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
