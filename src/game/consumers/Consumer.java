package game.consumers;

import game.Game;

public abstract class Consumer implements Runnable {
    protected int numberOfWorkers;
    protected long coolDownMs;
    protected String targetProduct = "";

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
        Integer currentQuantity = Game.inventory.get(targetProduct);
        if(currentQuantity > 0)
            Game.inventory.put(targetProduct,currentQuantity - 1);
        else
            Thread.currentThread().wait();
    }
}
