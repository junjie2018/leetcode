package T0174;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().calculateMinimumHP(new int[][]{
//                {-2, -3, 3},
//                {-5, -10, 1},
//                {10, 30, -5}
                {-1, 1}
        }));
    }
}

class Solution {

    private int rows, cols;
    private int[][] dungeon;

    public int calculateMinimumHP(int[][] dungeon) {

        int rows = dungeon.length, cols = dungeon[0].length;

        int[][] dp = new int[rows][cols];
        dp[rows - 1][cols - 1] = 1 - dungeon[rows - 1][cols - 1];
        if (dp[rows - 1][cols - 1] <= 0) {
            dp[rows - 1][cols - 1] = 1;
        }
        for (int i = rows - 2; i >= 0; i--) {
            dp[i][cols - 1] = dp[i + 1][cols - 1] - dungeon[i][cols - 1];
            if (dp[i][cols - 1] <= 0) {
                dp[i][cols - 1] = 1;
            }
        }
        for (int i = cols - 2; i >= 0; i--) {
            dp[rows - 1][i] = dp[rows - 1][i + 1] - dungeon[rows - 1][i];
            if (dp[rows - 1][i] <= 0) {
                dp[rows - 1][i] = 1;
            }
        }

        for (int i = rows - 2; i >= 0; i--) {
            for (int j = cols - 2; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                if (dp[i][j] <= 0) {
                    dp[i][j] = 1;
                }
            }
        }

        System.out.println();

        return dp[0][0];
    }

}
