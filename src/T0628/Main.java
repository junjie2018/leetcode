package T0628;

import Common.CommonUtils;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maximumProduct(
                CommonUtils.createInt1a("[1,2,3,4]")
        ));
    }
}

class Solution {


    public static final int F1 = -10001;
    public static final int F2 = 10001;

    public int maximumProduct(int[] nums) {
        if (nums.length == 3) return nums[0] * nums[1] * nums[2];

        int[] positive = new int[3];
        int[] negative = new int[2];

        Arrays.fill(positive, -1001);
        Arrays.fill(negative, 1001);

        for (int num : nums) {
            if (num > positive[0]) {
                positive[2] = positive[1];
                positive[1] = positive[0];
                positive[0] = num;
            } else if (num > positive[1]) {
                positive[2] = positive[1];
                positive[1] = num;
            } else if (num > positive[2]) {
                positive[2] = num;
            }


            if (num < negative[0]) {
                negative[1] = negative[0];
                negative[0] = num;
            } else if (num < negative[1]) {
                negative[1] = num;
            }

        }

        return Math.max(positive[0] * positive[1] * positive[2],
                negative[0] * negative[1] * positive[0]);
    }
}
