package T0473;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().makesquare(new int[]{
                5, 5, 5, 5, 16, 4, 4, 4, 4, 4, 3, 3, 3, 3, 4
        }));
    }
}

class Solution {
    private int[] nums;
    private int length;

    public boolean makesquare(int[] nums) {

        if (nums == null || nums.length == 0) {
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 4 != 0) {
            return false;
        }

        this.nums = nums;
        this.length = sum / 4;

        int[] flags = new int[nums.length];

        Arrays.sort(nums);
        return makesquareCore(0, 0, sum / 4, flags);
    }

    private boolean makesquareCore(int idx, int sum, int target, int[] flags) {

        sum += nums[idx];
        flags[idx] = 1;
        if (sum == target) {
            if (target != 4 * length) {
                target += length;
                idx = 0;
            } else {
                return true;
            }
        } else if (sum > target) {
            return false;
        }


        int preValue = -1;
        for (int i = idx + 1; i < nums.length; i++) {
            if (flags[i] != 1 && nums[i] != preValue) {
                preValue = nums[i];
                if (makesquareCore(i, sum, target, Arrays.copyOf(flags, flags.length))) {
                    return true;
                }
            }
        }
        return false;
    }
}