package game;

import game.producers.*;
import hw.MainFrame;
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
        assertNotEquals(Game.gamefields[0].getClass(), Woods.class);
    }
    @Test
    public void produce() throws InterruptedException, IOException {
        game.newGame(mainFrame);
        shop = new buildingShopFrame(Game.gamefields[0]);
        shop.setChoosedBuildingName("Woods");
        shop.addNew(mainFrame);
        Thread.sleep(Game.gamefields[0].coolDownMs);

        Woods woods = new Woods(game.player,mainFrame);
        assertEquals("Number of workers bad",1,Game.gamefields[0].numberOfWorkers);
        assertEquals(woods.getQuantity(),(long)game.player.inventory.get("Wood"));
    }
    @Test
    public void upgradeBuilding() throws IOException {
        game.newGame(mainFrame);
        shop = new buildingShopFrame(Game.gamefields[0]);
        shop.setChoosedBuildingName("Woods");
        shop.addNew(mainFrame);
        Game.gamefields[0].addWorker();

        assertEquals("Number of workers bad",2,Game.gamefields[0].numberOfWorkers);
    }
    @Test
    public void sellBuilding() throws IOException {
        game.newGame(mainFrame);
        shop = new buildingShopFrame(Game.gamefields[0]);
        shop.setChoosedBuildingName("Woods");
        shop.addNew(mainFrame);
        producerPropertyWindow.sellProducer  seller = new producerPropertyWindow(Game.gamefields[0]).createrSeller(Game.gamefields[0]);

        seller.sell();
        assertEquals("Number of workers bad",game.getInitGold(),game.player.getGold());
    }

}