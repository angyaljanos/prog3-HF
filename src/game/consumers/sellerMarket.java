package game.consumers;

import java.util.HashMap;

public class sellerMarket extends Consumer{
    public sellerMarket(HashMap<String,Integer> prices){
        numberOfWorkers = 1;
        this.prices = prices;
        coolDownMs = 3000;
    }
    public void sell(){

    }

    @Override
    public void addWorker() {
        numberOfWorkers++;
        coolDownMs = (long)(3000/numberOfWorkers);
    }

    @Override
    public void run() {
        try {
            sell();
            Thread.sleep(coolDownMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
