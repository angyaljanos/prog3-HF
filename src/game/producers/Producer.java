package game.producers;

import game.Player;
import game.baseBuilding;

import java.io.IOException;

public abstract class Producer extends baseBuilding implements Runnable {

    public Producer(String path) throws IOException {
        super(path);
    }

    public void addWorker(){
        numberOfWorkers++;
        coolDownMs = 3000/numberOfWorkers;
    }

    public void produce(String productName) throws InterruptedException {
        Integer currentQuantity = (Integer) Player.inventory.get(productName);
        if(currentQuantity > Player.capacityPerItem)
            Thread.currentThread().wait();
        else {
            int newQuantity = currentQuantity + 1 + (numberOfWorkers / 5);
            if (newQuantity > Player.capacityPerItem)
                newQuantity = Player.capacityPerItem;

            Player.inventory.put(productName, newQuantity);
        }
    }
}
