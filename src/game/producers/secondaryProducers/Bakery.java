package game.producers.secondaryProducers;

public class Bakery extends secondaryProducer {
    @Override
    public void run() {
        try {
            super.produce("Grains","Bread");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
