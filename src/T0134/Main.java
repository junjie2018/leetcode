package T0134;

import Common.CommonUtils;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().canCompleteCircuit(new int[]{
//                1, 2, 3, 4, 5
                5, 1, 2, 3, 4
        }, new int[]{
//                3, 4, 5, 1, 2
                4, 4, 1, 5, 1
        }));
    }
}


class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;

        int[] gasInit = new int[len];
        int sum = 0;
        for (int i = 0; i < len; i++) {
            gasInit[i] = gas[i] - cost[i];
            sum += gasInit[i];
        }

        if (sum < 0) {
            return -1;
        }

//        System.out.println(Arrays.toString(gasInit));

        int length = 0;
        int low = 0, high = 0;
        int partialSum = 0;

        while (length != len) {
            partialSum += gasInit[high];
            length++;
            high = (high + 1) % len;

            while (partialSum < 0) {
                partialSum -= gasInit[low];
                length--;
                low++;
            }
        }

        return low;
    }
}