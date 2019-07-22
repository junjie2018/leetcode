package T0041;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    }
}

class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) flag = true;
        }
        if (!flag) return 1;

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] <= 0 ? 1 : nums[i];
        }
        nums[0] = -nums[0]; // 将'1'处理掉，可以节约一点计算

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            if (index > 1 && index <= nums.length) {
                nums[index - 1] = -Math.abs(nums[index - 1]);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
