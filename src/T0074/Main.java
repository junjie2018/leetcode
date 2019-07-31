package T0074;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().searchMatrix(new int[][]{
//                {1, 3, 5, 7},
//                {10, 11, 16, 20},
//                {23, 30, 34, 50}
                {1}

        }, 1));
    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length, cols = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[rows - 1][cols - 1]) {
            return false;
        }

        for (int i = 0; i < rows; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][cols - 1]) {
//                int res = Arrays.binarySearch(matrix[i], target);
                return Arrays.binarySearch(matrix[i], target) >= 0;
            }
        }
        return false;
    }
}
