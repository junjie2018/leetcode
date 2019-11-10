package T0674;

import Common.CommonUtils;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findLengthOfLCIS(CommonUtils.createInt1a(
                "[1,3,5,4,7]"
        )));
    }
}

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        int maxLen = 1;
        int slow = 0, fast = 1;
        while (fast < nums.length) {
            if (nums[fast] > nums[fast - 1]) {
                int len = fast - slow + 1;
                if (len > maxLen) maxLen = len;
            } else {
                slow = fast;
            }
            ++fast;
        }

        return maxLen;
    }
}
