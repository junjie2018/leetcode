package T0706;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

    }
}

class MyHashMap {

    Map<Integer, Integer> map;

    public MyHashMap() {
        this.map = new HashMap<>();
    }

    public void put(int key, int value) {
        map.put(key, value);
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void remove(int key) {
        map.remove(key);
    }
}