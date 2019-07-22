package T0035;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution2().searchInsert(new int[]{1, 3, 5, 6}, 7));
    }
}

class Solution {
    public int searchInsert(int[] nums, int target) {
        int index = nums.length - 1;

        while (index >= 0 && target <= nums[index]) {
            if (target == nums[index]) {
                return index;
            }
            index--;
        }
        return index + 1;

    }
}

class Solution2 {
    public int searchInsert(int[] nums, int target) {
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
        if (target <= nums[left]) {
            return left;
        } else if (target <= nums[right]) {
            return right;
        } else {
            return right + 1;
        }
    }
}
