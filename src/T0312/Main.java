package T0312;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maxCoins(new int[]{3, 1, 5, 8}));
    }
}

class Solution {

    private int[] nums;
    private int[][] records;

    public int maxCoins(int[] nums) {

        int length = nums.length + 2;

        int[] tmp = new int[length];
        System.arraycopy(nums, 0, tmp, 1, nums.length);
        tmp[0] = 1;
        tmp[length - 1] = 1;

        nums = tmp;

        int[][] dp = new int[length][length];

        for (int len = 2; len < length; len++) {
            for (int i = 0; i < length - len; i++) {
                int max = 0;
                for (int j = i + 1; j < i + len; j++) {
                    max = Math.max(max, nums[i] * nums[j] * nums[i + len] + dp[i][j] + dp[j][i + len]);
                }
                dp[i][i + len] = max;
            }
        }
        return dp[0][length - 1];
    }

}