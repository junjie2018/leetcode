package T0096;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().numTrees(4));
    }
}

class Solution {

    private int[] dp;

    public int numTrees(int n) {
        if (n == 1) return 1;

        this.dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        numTreesCore(1, n);
        return dp[n];
    }

    public int numTreesCore(int left, int right) {

        int length = right - left + 1;
        if (length == 0 || length == 1 || length == 2 || dp[length] != 0) {
            return dp[length];
        }

        int sum = 0;
        for (int i = left; i <= right; i++) {
            int leftSum = numTreesCore(left, i - 1);
            int rightSum = numTreesCore(i + 1, right);
            sum += leftSum * rightSum;
        }
        dp[length] = sum;
        return sum;
    }
}
