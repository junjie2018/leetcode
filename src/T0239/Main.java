package T0239;

import Common.CommonUtils;

public class Main {
    public static void main(String[] args) {
        CommonUtils.show(new Solution().maxSlidingWindow(CommonUtils.create("[1,3,-1,-3,5,3,6,7]"), 3));
    }
}

@SuppressWarnings("all")
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return nums;

        int len = nums.length;

        int[] l2r = new int[len];
        int[] r2l = new int[len];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            max = i % k == 0 ? nums[i] : Math.max(max, nums[i]);
            l2r[i] = max;
        }

        max = Integer.MIN_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            max = i % k == k - 1 ? nums[i] : Math.max(max, nums[i]);
            r2l[i] = max;
        }

        int idx = 0;
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i <= len - k; i++) {
            int left = i, right = i + k - 1;
            result[idx++] = Math.max(r2l[left], l2r[right]);
        }

        return result;
    }
}
