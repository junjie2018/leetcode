package T0073;

public class Main {
    public static void main(String[] args) {

    }
}


class Solution {
    public void setZeroes(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0)
                    setZero(matrix, i, j);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 2019) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    private void setZero(int[][] matrix, int row, int col) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = matrix[row][i] != 0 ? 2019 : 0;
        }
        for (int j = 0; j < matrix.length; j++) {
            matrix[j][col] = matrix[j][col] != 0 ? 2019 : 0;
        }
    }
}
