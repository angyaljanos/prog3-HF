package game.producers;

public class Woods extends Producer{
    @Override
    public void run() {
        try {
            super.produce("Wood");
            Thread.sleep(coolDownMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
