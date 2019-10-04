package T1109;

import Common.CommonUtils;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        new Solution2().corpFlightBookings(
                CommonUtils.createInt2a("[[1,2,10],[2,3,20],[2,5,25]]"),
                5
                /*
                    [[2,2,30],[2,2,45]]
                    2
                 */
//                CommonUtils.createInt2a("[[2,2,30],[2,2,45]]"),
//                2
        );
    }
}

/**
 * 将map优化成数组，估计可以省不少时间
 */
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] booking : bookings) {
            map.put(booking[0], map.getOrDefault(booking[0], 0) + booking[2]);
            map.put(booking[1] + 1, map.getOrDefault(booking[1] + 1, 0) - booking[2]);
        }

        int[] result = new int[n];
        result[0] = map.getOrDefault(1, 0);
        for (int i = 1; i < n; i++) {
            result[i] = map.getOrDefault(i + 1, 0) + result[i - 1];
        }

        return result;
    }
}

/**
 * 将map优化成数组
 */
class Solution2 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] map = new int[n + 1];
        for (int[] booking : bookings) {
            map[booking[0] - 1] = map[booking[0] - 1] + booking[2];
            map[booking[1]] = map[booking[1]] - booking[2];
        }

        int[] result = new int[n];
        result[0] = map[0];
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] + map[i];
        }

        return result;
    }
}
