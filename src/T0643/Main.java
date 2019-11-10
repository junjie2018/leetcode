package T0643;

import Common.CommonUtils;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findMaxAverage(
                CommonUtils.createInt1a("[1,12,-5,-6,50,3]"),
                4
        ));
    }
}

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                sum += nums[i];
                continue;
            }

            if (sum > maxSum) maxSum = sum;

            sum += nums[i];
            sum -= nums[i - k];
        }

        if (sum > maxSum) maxSum = sum;

        return (double) maxSum / k;
    }
}
