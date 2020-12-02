package game.producers.secondaryProducers;

import game.Player;
import game.producers.Producer;

import java.io.IOException;

public abstract class secondaryProducer extends Producer {

    public secondaryProducer(String path) throws IOException {
        super(path);
    }

    public void produce(String resourceMaterial, String endProduct) throws InterruptedException {
        Integer currentResource = Player.inventory.get(resourceMaterial);
        Integer currentEndProduct = Player.inventory.get(endProduct);
        if(currentResource < 0 || currentEndProduct > 20){
            Thread.currentThread().wait();
        }
        else{
            Player.inventory.put(resourceMaterial,currentResource - 1);
            Player.inventory.put(endProduct,currentResource + 1);
            notifyAll();
        }
    }
}
