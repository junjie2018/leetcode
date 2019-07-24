package T0239;

public class Main {
    public static void main(String[] args) {
        new Solution().longestIncreasingPath(new int[][]{
//                {9, 9, 4}, {6, 6, 8}, {2, 1, 1}
                {3, 4, 5}, {3, 2, 6}, {2, 2, 1}
        });
    }
}

class Solution {
    private int rows, cols;
    private int[][] dp;
    private int[][] matrix;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        this.rows = matrix.length;
        this.cols = matrix[0].length;
        this.dp = new int[rows][cols];
        this.matrix = matrix;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dp[i][j] = dfs(i, j);
            }
        }

        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    private int dfs(int i, int j) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int max = 1;
        // 上
        if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) {
            max = Math.max(max, dfs(i - 1, j) + 1);
        }

        // 左
        if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) {
            max = Math.max(max, dfs(i, j - 1) + 1);
        }

        // 下
        if (i + 1 < rows && matrix[i + 1][j] > matrix[i][j]) {
            max = Math.max(max, dfs(i + 1, j) + 1);
        }

        // 右
        if (j + 1 < cols && matrix[i][j + 1] > matrix[i][j]) {
            max = Math.max(max, dfs(i, j + 1) + 1);
        }

        dp[i][j] = max;
        return dp[i][j];
    }
}

class Solution2 {
    private int rows, cols;
    private int[][] dp;
    private int[][] matrix;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        this.rows = matrix.length;
        this.cols = matrix[0].length;
        this.dp = new int[rows][cols];
        this.matrix = matrix;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dp[i][j] == 0) {
                    int max = 1;
                    // 上
                    if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) {
                        max = Math.max(max, dfs(i - 1, j) + 1);
                    }

                    // 左
                    if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) {
                        max = Math.max(max, dfs(i, j - 1) + 1);
                    }

                    // 下
                    if (i + 1 < rows && matrix[i + 1][j] > matrix[i][j]) {
                        max = Math.max(max, dfs(i + 1, j) + 1);
                    }

                    // 右
                    if (j + 1 < cols && matrix[i][j + 1] > matrix[i][j]) {
                        max = Math.max(max, dfs(i, j + 1) + 1);
                    }

                    dp[i][j] = max;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    private int dfs(int i, int j) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int max = 1;
        // 上
        if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) {
            max = Math.max(max, dfs(i - 1, j) + 1);
        }

        // 左
        if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) {
            max = Math.max(max, dfs(i, j - 1) + 1);
        }

        // 下
        if (i + 1 < rows && matrix[i + 1][j] > matrix[i][j]) {
            max = Math.max(max, dfs(i + 1, j) + 1);
        }

        // 右
        if (j + 1 < cols && matrix[i][j + 1] > matrix[i][j]) {
            max = Math.max(max, dfs(i, j + 1) + 1);
        }

        dp[i][j] = max;
        return dp[i][j];
    }
}