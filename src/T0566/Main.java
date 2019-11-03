package T0566;

import Common.CommonUtils;

public class Main {
    public static void main(String[] args) {
        new Solution().matrixReshape(
                CommonUtils.createInt2a("[[1,2],[3,4]]"),
                1, 4
        );
    }
}

class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int rows = nums.length, cols = nums[0].length;
        if (rows * cols != r * c) return nums;

        int[][] result = new int[r][c];
        int idx = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[idx / c][idx % c] = nums[i][j];
                ++idx;
            }
        }

        return result;
    }
}
