package T0059;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {

    private int[][] result;
    private int n = 1;

    public int[][] generateMatrix(int n) {
        this.result = new int[n][n];

        generateMatrixCore(0, n - 1, 0, n - 1);

        return result;
    }

    private void generateMatrixCore(int left, int right, int top, int bottom) {
        if (left > right || top > bottom) {
            return;
        }

        // 从左到右
        for (int i = left; i <= right; i++) {
            result[top][i] = n++;
        }
        ++top;

        // 从上到下
        for (int i = top; i <= bottom; i++) {
            result[i][right] = n++;
        }
        --right;

        // 从右到左
        for (int i = right; i >= left; i--) {
            result[bottom][i] = n++;
        }
        --bottom;

        // 从下到上
        for (int i = bottom; i >= top; i--) {
            result[i][left] = n++;
        }
        ++left;

        generateMatrixCore(left, right, top, bottom);
    }
}
