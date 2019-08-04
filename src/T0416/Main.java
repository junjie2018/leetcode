package T0416;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().canPartition(new int[]{
//                1, 2, 3, 5
//                1, 5, 5, 11
//                19, 33, 38, 60, 81, 49, 13, 61, 50, 73, 60, 82, 73, 29, 65, 62, 53, 29, 53, 86, 16, 83, 52, 67, 41, 53, 18, 48, 32, 35, 51, 72, 22, 22, 76, 97, 68, 88, 64, 19, 76, 66, 45, 29, 95, 24, 95, 29, 95, 76, 65, 35, 24, 85, 95, 87, 64, 97, 75, 88, 88, 65, 43, 79, 6, 5, 70, 51, 73, 87, 76, 68, 56, 57, 69, 77, 22, 27, 29, 12, 55, 58, 18, 30, 66, 53, 53, 81, 94, 76, 28, 41, 77, 17, 60, 32, 62, 62, 88, 61
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 100
        }));
    }
}

/**
 * 回溯法解题
 */
class Solution {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 == 1) {
            return false;
        }


        return canPartitionCore(nums, 0, sum / 2);
    }

    private boolean canPartitionCore(int[] nums, int idx, int target) {

        if (target == 0) {
            return true;
        }

        if (target < 0) {
            return false;
        }

        for (int i = idx + 1; i < nums.length; i++) {
            if (i > idx + 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (canPartitionCore(nums, i, target - nums[i])) {
                return true;
            }
        }

        return false;
    }
}

/**
 * 动态规划解题
 */
class Solution2 {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 == 1) {
            return false;
        }

        // TODO 使用动态规划完成这道题

        return false;
    }

}
