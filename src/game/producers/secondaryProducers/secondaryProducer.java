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

        Integer newResource = currentResource - getProd();
        Integer newEndProduct = currentResource + getQuantity();
        if((currentResource < 0 || currentEndProduct > Player.capacityPerItem)
                ||newResource <= 0 || newEndProduct >= Player.capacityPerItem)
        {
            Thread.currentThread().wait();
        }
        else{
            Player.inventory.put(resourceMaterial,newResource);
            Player.inventory.put(endProduct,newEndProduct);
            notifyAll();
        }
    }
}
