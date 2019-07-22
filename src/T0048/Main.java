package T0048;

import Common.CommonUtils;

public class Main {
    public static void main(String[] args) {
        // [[1,2,3],[4,5,6],[7,8,9]]
        int[][] arrays = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] arrays2 = new int[][]{
                {15, 13, 2, 5},
                {14, 3, 4, 1},
                {12, 6, 8, 9},
                {16, 7, 10, 11}
        };
        new Solution().rotate(arrays2);

        CommonUtils.show(arrays2);
    }
}

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length - 1;

        for (int i = 0; i <= n / 2; i++) {
            int tlX = i, tlY = i; // 左上顶点
            int trX = i, trY = n - i; // 右上顶点
            int blX = n - i, blY = i; // 左下顶点
            int brX = n - i, brY = n - i; // 右下顶点

            // 处理当前圈所在的行
            for (int j = i; j < trY; j++) {
                int len = j - tlX;

                int tmp = matrix[tlX][tlY + len];
                matrix[tlX][tlY + len] = matrix[blX - len][blY];
                matrix[blX - len][blY] = matrix[brX][brY - len];
                matrix[brX][brY - len] = matrix[trX + len][trY];
                matrix[trX + len][trY] = tmp;

//                CommonUtils.show(matrix);
            }
        }
    }
}