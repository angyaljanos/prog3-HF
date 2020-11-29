package game.producers;

import game.Game;

public abstract class Producer implements Runnable {
    protected int numberOfWorkers;
    protected long coolDownMs;
    public void addWorker(){
        numberOfWorkers++;
        coolDownMs = 3000/numberOfWorkers;
    }

    public void produce(String productName) throws InterruptedException {
        Integer currentQuantity = (Integer)Game.inventory.get(productName);
        if(currentQuantity > Game.capacityPerItem)
            Thread.currentThread().wait();
        else {
            int newQuantity = currentQuantity + 1 + (numberOfWorkers / 5);
            if (newQuantity > Game.capacityPerItem)
                newQuantity = Game.capacityPerItem;

            Game.inventory.put(productName, newQuantity);
        }
    }
}
