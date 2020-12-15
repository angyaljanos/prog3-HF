package hw;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import hw.game.baseBuilding;

public class JsonMaker {
    private static final Gson gson;
    private static final buildingDeserilializer deserilializer = new buildingDeserilializer();
    static {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.excludeFieldsWithoutExposeAnnotation();

        builder.registerTypeAdapter(baseBuilding.class,deserilializer);

        gson = builder.create();
    }

    public static Gson getGson() {
        return gson;
    }

    public static buildingDeserilializer getDeserilializer(){
        return deserilializer;
    }

}
