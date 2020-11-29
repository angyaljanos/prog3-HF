package game;

import java.util.HashMap;

public class Storage{
    private static final Integer capacity = 20;
    private  HashMap<String,Integer> store;

    public Storage(){
        store = new HashMap<>();
    }

    public  void put(String key,Integer value){
        store.put(key, value);
    }

    public boolean incrementByKey(String key){
        int current = (int)store.get(key);
        if(!store.containsKey(key) ||  current >= capacity){
            return false;
        }
        store.put(key,current + 1);
        return true;
    }
    public double sellAll(HashMap<String,Double> prices){
        double sum = 0;
        for(String item: store.keySet()){
            sum = prices.get(item) * store.get(item);
        }
        return sum;
    }

}
