package game.producers.secondaryProducers;

public class StoneCutter extends secondaryProducer{
    @Override
    public void run() {
        try {
            super.produce("Stone","Stone Brick");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
