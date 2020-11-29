package game.producers;

public class Fold extends Producer{    @Override
public void run() {
    try {
        super.produce("Leather");
        super.produce("Meat");
        Thread.sleep(coolDownMs);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
}
