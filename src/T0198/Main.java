package T0198;

import Common.CommonUtils;

public class Main {
    public static void main(String[] args) {
        new Solution2().rob(CommonUtils.createInt1a("[1,2,3,1]"));
    }
}

class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 2];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 2], dp[i - 1]);
        }
        return dp[dp.length - 1];
    }
}

/*
    超出时间限制了
 */
class Solution2 {

    private int[] nums;

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        this.nums = nums;

        return robCore(0);
    }

    private int robCore(int idx) {
        if (idx + 1 >= nums.length) return nums[idx];
        if (idx + 2 >= nums.length) return Math.max(robCore(idx + 1), nums[idx]);
        return Math.max(robCore(idx + 1), robCore(idx + 2) + nums[idx]);
    }
}
