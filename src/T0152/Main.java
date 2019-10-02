package T0152;

import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution2().maxProduct(new int[]{
//                2,3,-2,4
//                -2, 0, -1
//                -2
                3, -1, 4
//                2, -5, -2, -4, 3
        }));
    }
}

/*
    这个有动态的思想在里面，但是运行的时间有点长
 */
class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int pre = 0;
            for (int j = i; j < len; j++) {
                pre = i == j ? nums[j] : nums[j] * pre;
                if (pre > max) max = pre;
            }
        }
        return max;
    }
}

class Solution2 {
    public int maxProduct(int[] nums) {

        int max = nums[0], min = nums[0], res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int tmpMax = max, tmpMin = min;

            if (num == 0) {
                max = 0;
                min = 0;
            }

            if (num > 0) {
                max = Math.max(num, tmpMax * num);
                min = Math.min(num, tmpMin * num);
            }

            if (num < 0) {
                max = getMax(num, num * tmpMax, num * tmpMin);
                min = getMin(num, num * tmpMin, num * tmpMax);
            }

            if (max > res) res = max;
        }

        return res;
    }

    private int getMax(int a, int b, int c) {
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        return max;
    }

    private int getMin(int a, int b, int c) {
        int min = a;
        if (b < min) min = b;
        if (c < min) min = c;
        return min;
    }
}
