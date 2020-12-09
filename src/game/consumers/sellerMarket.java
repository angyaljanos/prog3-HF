package game.consumers;

import game.Game;
import game.Player;
import hw.MainFrame;

import java.io.IOException;


public class sellerMarket extends Consumer{
    public sellerMarket(Player player, MainFrame mainFrame) throws IOException {
        super("sellermarket.jpg", player , mainFrame);
        numberOfWorkers = 1;
        coolDownMs = 3000;
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
