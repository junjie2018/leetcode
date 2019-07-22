package T0016;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().threeSumClosest(new int[]{0, 1, 2}, 3));
    }
}

class Solution {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);


        int delta = Integer.MAX_VALUE;
        int result = 0;
        int base = 0, left, right;
        while (base < nums.length - 2) {
            left = base + 1;
            right = nums.length - 1;

            while (left < right) {
                int sum = nums[base] + nums[left] + nums[right];
                if (Math.abs(target - sum) < delta) {
                    result = sum;
                    delta = Math.abs(target - sum);
                }
                if (sum < target) {
                    left = moveLeft(nums, left);
                } else if (sum > target) {
                    right = moveRight(nums, right);
                } else {
                    return sum;
                }
            }
            base = moveBase(nums, base);
        }
        return result;
    }

    private int moveBase(int[] nums, int base) {
        do {
            base++;
        } while (base < nums.length - 1 && nums[base] == nums[base - 1]);
        return base;
    }

    private int moveRight(int[] nums, int right) {
        do {
            right--;
        } while (right > 0 && nums[right] == nums[right + 1]);
        return right;
    }

    private int moveLeft(int[] nums, int left) {
        do {
            left++;
        } while (left < nums.length - 1 && nums[left] == nums[left - 1]);
        return left;
    }
}
