package T0453;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num < min) min = num;
        }

        int res = 0;
        for (int num : nums) {
            res += num - min;
        }

        return res;
    }
}