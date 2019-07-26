package T0221;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
//        System.out.println(new Solution().maximalSquare(new char[][]{
////                {'1', '0', '1', '0', '0'},
////                {'1', '0', '1', '1', '1'},
////                {'1', '1', '1', '1', '1'},
////                {'1', '0', '0', '1', '0'}
//                {'1', '1'},
//                {'1', '1'}
//        }));

        System.out.println(new Solution2().maximalSquare(new char[][]{
                {'0', '0', '0', '1', '0', '1', '1', '1'},
                {'0', '1', '1', '0', '0', '1', '0', '1'},
                {'1', '0', '1', '1', '1', '1', '0', '1'},
                {'1', '0', '1', '1', '1', '1', '0', '1'},
                {'0', '0', '0', '1', '0', '0', '0', '0'},
                {'0', '0', '1', '0', '0', '0', '1', '0'},
                {'1', '1', '1', '0', '0', '1', '1', '1'},
                {'1', '0', '0', '1', '1', '0', '0', '1'},
                {'0', '1', '0', '0', '1', '1', '0', '0'},
                {'1', '0', '0', '1', '0', '0', '0', '0'}
        }));

    }
}

class Solution {
    int rows, cols;
    //    int[][] dp;
    char[][] matrix;


    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        this.rows = matrix.length;
        this.cols = matrix[0].length;
//        this.dp = new int[rows][cols];
        this.matrix = matrix;

        int max = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == '1') {
                    max = Math.max(max, maximalSquareCore(row, col));
                }
            }
        }
        return max * max;
    }

    public int maximalSquareCore(int row, int col) {

        int i = 2;
        while (true) {

            int trX = row, trY = col + i - 1;
            int blX = row + i - 1, blY = col;
            int brX = row + i - 1, brY = col + i - 1;

            if (brX >= rows || brY >= cols) {
                return i - 1;
            }

            for (int j = trX; j <= brX; j++) {
                if (matrix[j][trY] != '1') {
                    return i - 1;
                }
            }

            for (int j = blY; j <= brY; j++) {
                if (matrix[blX][j] != '1') {
                    return i - 1;
                }
            }

            i++;
        }
    }
}

class Solution2 {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int rows = matrix.length, cols = matrix[0].length;

        int[][] dp = new int[rows + 1][cols + 1];

        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    int m = i + 1, n = j + 1;
                    dp[m][n] = Math.min(dp[m - 1][n - 1], Math.min(dp[m - 1][n], dp[m][n - 1])) + 1;
                    max = Math.max(max, dp[m][n]);
                }
            }
        }
        return max * max;
    }
}
