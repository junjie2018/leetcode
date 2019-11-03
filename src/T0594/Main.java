package T0594;

import Common.CommonUtils;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findLHS(
                CommonUtils.createInt1a("[1,3,2,2,5,2,3,7]")
        ));
    }
}

class Solution {
    public int findLHS(int[] nums) {
        if (null == nums || nums.length == 0) return 0;

        Arrays.sort(nums);

        int max = 0;
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            int tmp = nums[fast] - nums[slow];

            if (1 == tmp) {
                max = Math.max(max, fast - slow + 1);
                ++fast;
            } else if (tmp < 1) {
                ++fast;
            } else {
                while (tmp > 1) {
                    ++slow;
                    tmp = nums[fast] - nums[slow];
                }
                if (1 == tmp) {
                    max = Math.max(max, fast - slow + 1);
                }
            }
        }
        return max;
    }
}