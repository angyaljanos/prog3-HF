package game.consumers;

import game.PlayerData;

import java.io.Serializable;
import java.util.HashMap;

public abstract class Consumer implements Runnable {
    protected int numberOfWorkers;
    protected long coolDownMs;
    protected HashMap<String,Integer> prices;

    public void addWorker(){

    }

}
