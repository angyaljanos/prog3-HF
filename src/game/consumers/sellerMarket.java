package game.consumers;

import game.Game;
import game.Player;

import java.io.IOException;
import java.util.HashMap;

public class sellerMarket extends Consumer{
    public sellerMarket(Player player) throws IOException {
        super("../../resources/market.jpg", player);
        buildingName = "Seller Market Lv." + numberOfWorkers;
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
