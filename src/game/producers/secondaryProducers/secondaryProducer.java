package game.producers.secondaryProducers;

import game.Player;
import game.producers.Producer;
import hw.MainFrame;

import java.io.IOException;

public abstract class secondaryProducer extends Producer {

    public secondaryProducer(String path,Player player, MainFrame mainFrame) throws IOException {
        super(path, player, mainFrame);
    }

    public void produce(String resourceMaterial, String endProduct) throws InterruptedException {
        Integer currentResource = owner.inventory.get(resourceMaterial);
        Integer currentEndProduct =  owner.inventory.get(endProduct);

        Integer newResource = currentResource - getQuantity();
        Integer newEndProduct = currentResource + getQuantity();
        if((currentResource < 0 || currentEndProduct > Player.capacityPerItem)
                ||newResource <= 0 || newEndProduct >= Player.capacityPerItem)
        {
            Thread.currentThread().wait();
        }
        else{
            owner.inventory.put(resourceMaterial,newResource);
            owner.inventory.put(endProduct,newEndProduct);
            notifyAll();
        }
    }
}
