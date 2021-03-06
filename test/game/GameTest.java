package game;

import hw.MainFrame;
import hw.game.Game;
import hw.game.baseBuilding;
import hw.game.buildingShopFrame;
import hw.game.consumers.Consumer;
import hw.game.producers.Woods;
import hw.game.producers.producerPropertyWindow;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;

public class GameTest {

    MainFrame mainFrame;
    Game game;
    buildingShopFrame shop;

    @Before
    public void setup() throws FileNotFoundException {
        mainFrame = new MainFrame();
        game = new Game(mainFrame);

    }

    @Test
    public void newGame() {
        game.newGame(mainFrame);
        assertEquals("Player's initial gold is bad",game.getInitGold(),game.player.getGold());
        assertFalse(Game.prices.isEmpty());
        for(baseBuilding item: Game.gamefields){
            assertEquals(item.getClass(),baseBuilding.class);
        }
    }

    @Test
    public void continuePreviousGame() throws IOException {
        game.newGame(mainFrame);
        shop = new buildingShopFrame(Game.gamefields[0]);
        shop.setChoosedBuildingName("Woods");
        shop.addNew(mainFrame);
        game.save();

        game.continuePreviousGame(mainFrame);
        assertEquals(Game.gamefields[0].getClass(), Woods.class);
    }
    @Test
    public void produce() throws InterruptedException, IOException {
        game.newGame(mainFrame);
        shop = new buildingShopFrame(Game.gamefields[0]);
        shop.setChoosedBuildingName("Woods");
        shop.addNew(mainFrame);
        Thread.sleep(Game.gamefields[0].getCoolDownMs() - 50);

        assertEquals("Number of workers bad",1,Game.gamefields[0].getNumberOfWorkers());
        assertEquals(Game.gamefields[0].getQuantity(),(long)game.player.inventory.get("Wood"));
    }
    @Test
    public void upgradeBuilding() throws IOException {
        game.newGame(mainFrame);
        shop = new buildingShopFrame(Game.gamefields[0]);
        shop.setChoosedBuildingName("Woods");
        shop.addNew(mainFrame);
        Game.gamefields[0].addWorker();

        assertEquals("Number of workers bad",2,Game.gamefields[0].getNumberOfWorkers());
    }
    @Test
    public void sellBuilding() throws IOException {
        game.newGame(mainFrame);
        shop = new buildingShopFrame(Game.gamefields[0]);
        shop.setChoosedBuildingName("Woods");
        shop.addNew(mainFrame);
        producerPropertyWindow.sellProducerListener seller = new producerPropertyWindow(Game.gamefields[0]).createrSellProducerListener(Game.gamefields[0]);

        seller.sell();
        assertEquals(11,game.player.getGold());
    }
    @Test
    public void testConsumer() throws IOException, InterruptedException {
        game.newGame(mainFrame);
        shop = new buildingShopFrame(Game.gamefields[0]);
        shop.setChoosedBuildingName("Seller Market");
        shop.addNew(mainFrame);
        int initValue = 3;
        game.player.inventory.put("Wood",3);
        ((Consumer)Game.gamefields[0]).setTargetProduct("Wood");

        Thread.sleep(Game.gamefields[0].getCoolDownMs() + 50);

        assertNotEquals(initValue,(long)game.player.inventory.get("Wood"));
    }
}