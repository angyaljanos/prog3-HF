package game.producers.secondaryProducers;

public class Tanner extends secondaryProducer {
    @Override
    public void run() {
        try {
            super.produce("Leather","Leather Clothing");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
