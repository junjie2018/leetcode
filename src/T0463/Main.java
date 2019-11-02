package T0463;

import Common.CommonUtils;

public class Main {
    public static void main(String[] args) {
        new Solution().islandPerimeter(
                CommonUtils.createInt2a("[[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]")
        );
    }
}

class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;

        int perimeter = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    if (row - 1 < 0 || grid[row - 1][col] == 0) perimeter++;
                    if (row + 1 >= rows || grid[row + 1][col] == 0) perimeter++;
                    if (col - 1 < 0 || grid[row][col - 1] == 0) perimeter++;
                    if (col + 1 >= cols || grid[row][col + 1] == 0) perimeter++;
                }
            }
        }

        return perimeter;
    }
}
