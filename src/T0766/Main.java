package T0766;

import Common.CommonUtils;

/*
[
    [44,35,39],
    [15,44,35],
    [17,15,44],
    [80,17,15],
    [43,80,0],
    [77,43,80]]
 */

/*
[
    [63,18,62,88,23],
    [49,63,18,62,88],
    [0,49,63,18,62],
    [2,67,49,63,18],
    [50,2,67,49,63],
    [94,50,2,67,49]]
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isToeplitzMatrix(
//                CommonUtils.createInt2a("[[1,2,3,4,5],[5,1,2,3,4],[9,5,1,2,3]]")
//                CommonUtils.createInt2a("[[44,35,39],[15,44,35],[17,15,44],[80,17,15],[43,80,0],[77,43,80]]")
//                CommonUtils.createInt2a("[[18],[66]]")
                CommonUtils.createInt2a("[[63,18,62,88,23],[49,63,18,62,88],[0,49,63,18,62],[2,67,49,63,18],[50,2,67,49,63],[94,50,2,67,49]]")
        ));
    }
}

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;


        for (int i = 0; i < cols; i++) {
            int init = matrix[rows - 1][i];
            for (int j = 1; j < rows; j++) {
                int row = rows - 1 - j;
                int col = i - j;
                if (row < 0 || col < 0) break;
                if (matrix[row][col] != init) return false;
            }
        }

        for (int i = 0; i < rows; i++) {
            int init = matrix[i][cols - 1];
            for (int j = 1; j < cols; j++) {
                int row = i - j;
                int col = cols - 1 - j;
                if (row < 0 || col < 0) break;
                if (matrix[row][col] != init) return false;
            }
        }


        return true;
    }
}