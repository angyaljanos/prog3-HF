package game.consumers;

import game.Game;
import game.Player;
import game.baseBuilding;

import java.io.IOException;

public abstract class Consumer extends baseBuilding implements Runnable {

    protected String targetProduct = "";

    public Consumer(String path) throws IOException {
        super(path);
    }

    public void setTargetProduct(String targetProduct) {
        this.targetProduct = targetProduct;
    }

    public void addWorker(){
        numberOfWorkers++;
        coolDownMs = 3000/numberOfWorkers;
    }

    public void run() {
        try {
            sell();
            notifyAll();
            Thread.sleep(coolDownMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void sell() throws InterruptedException {
        Integer currentQuantity = Player.inventory.get(targetProduct);
        Integer newQuantity = currentQuantity - 1 - (numberOfWorkers/5);
        if(currentQuantity <= 0)
            Thread.currentThread().wait();
        else {
            Player.inventory.put(targetProduct, newQuantity > 0 ? newQuantity : 0);
            Player.gold += newQuantity * Game.prices.get(targetProduct);
        }
    }
}
