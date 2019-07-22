package T0053;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = nums[i] > (sums[i - 1] + nums[i]) ? nums[i] : sums[i - 1] + nums[i];
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < sums.length; i++) {
            max = sums[i] > max ? sums[i] : max;
        }

        return max;
    }
}
