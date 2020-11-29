package game.producers.secondaryProducers;

public class Oven extends secondaryProducer {
    @Override
    public void run() {
        try {
            super.produce("Meat","Roast");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
