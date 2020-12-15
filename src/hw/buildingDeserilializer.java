package hw;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import hw.game.Player;
import hw.game.baseBuilding;
import hw.game.consumers.sellerMarket;
import hw.game.producers.*;
import hw.game.producers.secondaryProducers.*;

import java.io.IOException;
import java.lang.reflect.Type;

public class buildingDeserilializer  implements JsonDeserializer<baseBuilding> {
    MainFrame mainFrame;
    Player player;
    @Override
    public baseBuilding deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        String name = jsonElement.getAsJsonObject().get("name").getAsString();
        Integer numOfWorkers =jsonElement.getAsJsonObject().get("numberOfWorkers").getAsInt();
        Integer cost =jsonElement.getAsJsonObject().get("cost").getAsInt();

        baseBuilding tmp;
        try {
            switch (name) {
                case "Woods":
                    tmp = new Woods(player, mainFrame);
                    break;
                case "Quarry":
                    tmp = new Quarry(player,mainFrame);
                    break;
                case "Fold":
                    tmp = new Fold(player,mainFrame);
                    break;
                case "Land":
                    tmp = new Land(player,mainFrame);
                    break;
                case "Mine Shaft":
                    tmp = new MineShaft(player,mainFrame);
                    break;
                case "Seller Market":
                    tmp = new sellerMarket(player,mainFrame);
                    break;
                case "Saw Mill":
                    tmp = new Sawmill(player,mainFrame);
                    break;
                case "Stone Cutter":
                    tmp = new StoneCutter(player,mainFrame);
                    break;
                case "Bakery":
                    tmp = new Bakery(player,mainFrame);
                    break;
                case "Oven":
                    tmp = new Oven(player,mainFrame);
                    break;
                case "Smeltery":
                    tmp = new Smeltery(player,mainFrame);
                    break;
                case "Tanner":
                    tmp = new Tanner(player,mainFrame);
                    break;
                default:
                    tmp = new baseBuilding(player,mainFrame);
            }
            tmp.setCost(cost);
            tmp.setNumberOfWorkers(numOfWorkers);
        }
        catch (IOException e){
            throw new JsonParseException(e);
        }
        return tmp;
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
