package T0034;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution2().searchRange(new int[]{2,2}, 2)));
    }
}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int index = binarySearch(nums, target);
        if (index == -1) {
            return new int[]{-1, -1};
        } else {
            int left = index, right = index;
            while (left - 1 >= 0 && nums[left] == nums[left - 1]) {
                --left;
            }
            while (right + 1 < nums.length && nums[right] == nums[right + 1]) {
                ++right;
            }
            return new int[]{left, right};
        }
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (target == nums[left]) return left;
        if (target == nums[right]) return right;
        return -1;
    }
}

class Solution2 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int min = binarySearchMin(nums, target);
        if (min == -1) return new int[]{-1, -1};


        int max = binarySearchMax(nums, target);

        return new int[]{min, max};
    }

    private int binarySearchMin(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left + 1 < right) {

            int mid = (left + right) / 2;
            if (target <= nums[mid]) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (target == nums[left]) return left;
        if (target == nums[right]) return right;
        return -1;
    }

    private int binarySearchMax(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left + 1 < right) {

            int mid = (left + right) / 2;
            if (target >= nums[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (target == nums[right]) return right;
        if (target == nums[left]) return left;

        return -1;
    }


}
