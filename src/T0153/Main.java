package T0153;

public class Main {
    public static void main(String[] args) {

    }
}

/*
    偷懒的写法
 */
class Solution {
    public int findMin(int[] nums) {
        int pre = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < pre) return nums[i];
        }
        return pre;
    }
}