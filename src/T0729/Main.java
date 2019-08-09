package T0729;

import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

    }
}

/**
 * 比较简单的方案
 */
class MyCalendar {

    private int idx = 0;
    private int[] starts = new int[100];
    private int[] ends = new int[100];

    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        for (int i = 0; i < idx; i++) {
            if (start >= ends[i] || end < starts[i]) {
                continue;
            }
            return false;
        }

        starts[idx] = start;
        ends[idx] = end;
        idx++;
        return true;
    }
}

/**
 * 使用TreeMap解题
 */
class MyCalendar2 {

    TreeMap<Integer, Integer> booked = new TreeMap<>();

    public MyCalendar2() {

    }

    public boolean book(int start, int end) {
        Integer floor = booked.floorKey(start);
        Integer ceiling = booked.ceilingKey(start);


        if ((floor == null || booked.get(floor) <= start) && (ceiling == null || ceiling >= end)) {
            booked.put(start, end);
            return true;
        }

        return false;
    }
}
