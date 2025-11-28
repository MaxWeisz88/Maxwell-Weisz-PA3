package main;
import java.util.*;

public class HashMap {
    private static final int DEFAULT_SIZE = 16;
    private static final double DEFAULT_LF = .7;
    int mapSize = 0;
    Entry[] map = new Entry[mapSize];
    Double loadFactor = 0.00;

    public HashMap(){
        mapSize = 20;
        map = new Entry[mapSize];
    }

    public HashMap(int size, double loadFactor){
        mapSize = size;
        this.loadFactor = loadFactor;
        map = new Entry[mapSize];
    }

    public int hashFunction(String key){
        int result = 0;
        int digits = 0;
        char[] keyArr = key.toCharArray();
        for(char ch : keyArr){
            if(ch == '-'){
                break;
            }
            int charDigit = (int)ch;
            digits += charDigit;
        }
        result = (int)Math.floor(mapSize*((digits*0.49)%1));
        return result;
    }

    public int getValue(GraphNode g){
        int value = -1;
        if(hasKey(g)){
            
        }
        return value;
    }

    public void set(GraphNode key, int value){
        if(hasKey(key)){
            Entry entry = getEntry(key);
            entry.setValue(value);
        }else{
            int i = hashFunction(key.getId());
            map[i] = new Entry(key, value);
        }
    }

    public Entry getEntry(GraphNode key){
        Entry keysEntry = map[hashFunction(key.getId())];
        return keysEntry;
    }

    public boolean hasKey(GraphNode g){
        boolean containsKey = false;
        if(map[hashFunction(g.getId())] != null){
            containsKey = true;
        }
        return containsKey;
    }
}
