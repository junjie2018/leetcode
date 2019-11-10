package T0705;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

    }
}

class MyHashSet {

    private Set<Integer> set;

    public MyHashSet() {
        this.set = new HashSet<>();
    }

    public void add(int key) {
        set.add(key);
    }

    public void remove(int key) {
        set.remove(key);
    }

    public boolean contains(int key) {
        return set.contains(key);
    }
}
