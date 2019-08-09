package T0731;

import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

    }
}

class MyCalendarTwo {

    TreeMap<Integer, Integer> booked = new TreeMap<>();

    public MyCalendarTwo() {

    }

    public boolean book(int start, int end) {
        booked.put(start, booked.getOrDefault(start, 0) + 1);
        booked.put(end, booked.getOrDefault(end, 0) - 1);

        int activeEvent = 0;
        for (int freq : booked.values()) {
            activeEvent += freq;
            if (activeEvent >= 3) {
                booked.put(start, booked.getOrDefault(start, 0) - 1);
                booked.put(end, booked.getOrDefault(end, 0) + 1);
                return false;
            }
        }
        return true;
    }
}

