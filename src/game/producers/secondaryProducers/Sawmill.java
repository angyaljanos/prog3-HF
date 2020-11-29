package game.producers.secondaryProducers;

public class Sawmill extends secondaryProducer {
    @Override
    public void run() {
        try {
            super.produce("Wood","Planks");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
