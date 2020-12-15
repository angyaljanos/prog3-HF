package hw.game.consumers;

import hw.game.Player;
import hw.MainFrame;

import java.io.IOException;


public class sellerMarket extends Consumer{
    public sellerMarket(Player player, MainFrame mainFrame) throws IOException {
        super("sellermarket.jpg", player , mainFrame);
        name = "Seller Market";
        numberOfWorkers = 1;
        coolDownMs = 5000;
        this.targetProduct = "";
        cost = 2;
    }

    @Override
    public void addWorker() {
        super.addWorker();
    }

    @Override
    protected String getBaseName() {
        return "Seller Market";
    }

    @Override
    public void run(){
        super.run();
    }
}
