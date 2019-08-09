package T0300;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        System.out.println(new Solution().lengthOfLIS(new int[]{
////                10, 9, 2, 5, 3, 7, 101, 18
//                1, 3, 6, 7, 9, 4, 10, 5, 6
//        }));
        System.out.println(Arrays.binarySearch(new int[]{
              1
        }, 0, 1, 10));
    }
}

/**
 * 使用常规方法解
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] length = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int maxIdx = i;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (length[j] > length[maxIdx]) {
                        maxIdx = j;
                    }
                }
            }
            length[i] = length[maxIdx] + 1;
        }

        int maxLength = 0;
        for (int i = 0; i < length.length; i++) {
            if (length[i] > maxLength) {
                maxLength = length[i];
            }
        }

        return maxLength;
    }
}

/**
 * 使用动态规划
 */
class Solution2 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int idx = Arrays.binarySearch(dp, 0, len, num);
            if (idx < 0) {
                idx = -(idx + 1);
            }
            dp[idx] = num;
            if (idx == len) {
                len++;
            }
        }
        return len;
    }
}
