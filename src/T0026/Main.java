package T0026;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        int fast = 1;
        int slow = 0;

        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}