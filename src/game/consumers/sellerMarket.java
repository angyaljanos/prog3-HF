package game.consumers;

import java.io.IOException;

public class sellerMarket extends Consumer{
    public sellerMarket() throws IOException {
        super("../../resources/market.jpg");
        numberOfWorkers = 1;
        coolDownMs = 3000;
        this.targetProduct = "";
    }

    @Override
    public void addWorker() {
        super.addWorker();
    }

    @Override
    public void run(){
        super.run();
    }
}
