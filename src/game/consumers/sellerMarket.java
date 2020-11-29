package game.consumers;

import java.util.HashMap;

public class sellerMarket extends Consumer{
    public sellerMarket(HashMap<String,Integer> prices){
        numberOfWorkers = 1;
        this.prices = prices;
        coolDownMs = 3000;
    }
    public void sell(){
        ///nincs kész
    }

    @Override
    public void addWorker() {
        super.addWorker();
    }

    @Override
    public void run() {
        try {
            sell();
            notifyAll();
            Thread.sleep(coolDownMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
