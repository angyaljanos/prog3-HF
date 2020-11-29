package game.producers.secondaryProducers;

import game.Game;
import game.producers.Producer;

public abstract class secondaryProducer extends Producer {

    public void produce(String resourceMaterial, String endProduct) throws InterruptedException {
        Integer currentResource = Game.inventory.get(resourceMaterial);
        Integer currentEndProduct = Game.inventory.get(endProduct);
        if(currentResource < 0 || currentEndProduct > 20){
            Thread.currentThread().wait();
        }
        else{
            Game.inventory.put(resourceMaterial,currentResource - 1);
            Game.inventory.put(endProduct,currentResource + 1);
            notifyAll();
        }
    }
}
