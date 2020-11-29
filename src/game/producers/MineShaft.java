package game.producers;

public class MineShaft extends Producer{
    @Override
    public void run() {
        try {
            super.produce("Ore");
            Thread.sleep(coolDownMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
