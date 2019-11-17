package T0724;

import Common.CommonUtils;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().pivotIndex(
                CommonUtils.createInt1a("[-1,-1,-1,-1,-1,0]")
        ));
    }
}

class Solution {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int leftSum = 0, rightSum = 0;

        for (int i = 1; i < nums.length; i++) {
            rightSum += nums[i];
        }

        if (leftSum == rightSum) return 0;

        for (int i = 1; i < nums.length; i++) {
            leftSum += nums[i - 1];
            rightSum -= nums[i];
            if (leftSum == rightSum) return i;
        }

        return -1;
    }
}
