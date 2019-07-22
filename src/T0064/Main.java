package T0064;

public class Main {
    public static void main(String[] args) {
        new Solution().minPathSum(new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1},
        });
    }
}

class Solution {
    public int minPathSum(int[][] grid) {
        int X = grid.length, Y = grid[0].length;

        int[][] stat = new int[X][Y];
        stat[0][0] = grid[0][0];

        // 初始化行
        for (int i = 1; i < Y; i++) {
            stat[0][i] = stat[0][i - 1] + grid[0][i];
        }

        // 初始化列
        for (int i = 1; i < X; i++) {
            stat[i][0] = stat[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < X; i++) {
            for (int j = 1; j < Y; j++) {
                stat[i][j] = Math.min(stat[i - 1][j] + grid[i][j], stat[i][j - 1] + grid[i][j]);
            }
        }

        return stat[X - 1][Y - 1];
    }
}
