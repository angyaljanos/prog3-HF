package game.producers;

public class Quarry extends Producer{
    @Override
    public void run() {
        try {
            super.produce("Stone");
            Thread.sleep(coolDownMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
