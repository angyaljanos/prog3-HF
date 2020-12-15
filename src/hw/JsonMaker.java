package hw;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonMaker {
    private static final Gson gson;
    static {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.excludeFieldsWithoutExposeAnnotation();

        gson = builder.create();
    }

    public static Gson getGson() {
        return gson;
    }
}
