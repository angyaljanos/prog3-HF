package game.consumers;

import java.util.HashMap;

public abstract class Consumer implements Runnable {
    protected int numberOfWorkers;
    protected long coolDownMs;
    protected HashMap<String,Integer> prices;


    public void addWorker(){
        numberOfWorkers++;
        coolDownMs = 3000/numberOfWorkers;
    }

    public void sell(String productName){

    }
}
