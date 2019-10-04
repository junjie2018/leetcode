package T0853;

import Common.CommonUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().carFleet(
                12,
                CommonUtils.createInt1a("[10,8,0,5,3]"),
                CommonUtils.createInt1a("[2,4,1,1,3]")
        ));
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        if (position == null || position.length == 0) return 0;

        int len = position.length;

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            cars.add(new Car(position[i], (double) (target - position[i]) / (double) speed[i]));
        }

        cars.sort(Comparator.comparingInt(a -> a.position));

        int sum = 1;
        for (int i = cars.size() - 2; i >= 0; i--) {
            if (cars.get(i).time <= cars.get(i + 1).time) {
                cars.get(i).time = cars.get(i + 1).time;
            } else {
                sum++;
            }
        }

        return sum;

    }

    private static class Car {
        int position;
        double time;

        public Car(int position, double time) {
            this.position = position;
            this.time = time;
        }
    }
}

/**
 * 非常巧妙，记录一下
 */
class Solution2 {
    public int carFleet(int target, int[] pos, int[] speed) {
        if (pos.length == 0) return 0;
        int[] v = new int[target];
        for (int i = 0; i < pos.length; i++) {
            v[pos[i]] = speed[i];
        }

        double maxT = -1;
        int res = 0;
        for (int i = target - 1; i >= 0; i--) {
            if (v[i] == 0) continue;
            double t = (double) (target - i) / v[i];
            if (t > maxT || maxT == -1) {
                maxT = t;
                res++;
            }
        }

        return res;
    }
}
