package T0732;

import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

    }
}

class MyCalendarThree {

    TreeMap<Integer, Integer> booked = new TreeMap<>();

    public MyCalendarThree() {

    }

    public int book(int start, int end) {
        booked.put(start, booked.getOrDefault(start, 0) + 1);
        booked.put(end, booked.getOrDefault(end, 0) - 1);

        int max = 0;
        int activeEvent = 0;
        for (int freq : booked.values()) {
            activeEvent += freq;
            if (activeEvent > max) {
                max = activeEvent;
            }
        }
        return max;
    }
}
