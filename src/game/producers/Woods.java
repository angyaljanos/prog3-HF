package game.producers;

import game.Player;
import hw.MainFrame;

import java.io.IOException;

public class Woods extends Producer{
    public Woods(Player player, MainFrame mainFrame) throws IOException {
        super("woods.jpg", player, mainFrame);
        cost = 1;
    }

    @Override
    public long getCost(){
        return cost;
    }

    @Override
    protected String getBaseName(){
        return "Woods";
    }

    @Override
    public void run() {
        try {
            super.produce("Wood");
            System.out.println("+1");
            Thread.sleep(coolDownMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
