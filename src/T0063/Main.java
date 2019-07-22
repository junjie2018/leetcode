package T0063;

import Common.CommonUtils;

import java.sql.Connection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
//        String input = "[[0,0,0],[0,1,0],[0,0,0]]";
//        Pattern pattern = Pattern.compile("[.*]");
//        Matcher matcher = pattern.matcher(input);
//
//        System.out.println(matcher.group());

        System.out.println();

        System.out.println(new Solution2().uniquePathsWithObstacles(new int[][]{
//                {0, 0, 0},
//                {0, 1, 0},
//                {0, 0, 0}
//                {1}
                {0,0},
                {1,0}
        }));
    }
}

class Solution {

    private int X, Y;
    private int[][] obstacleGrid;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        this.X = obstacleGrid.length;
        this.Y = obstacleGrid[0].length;
        this.obstacleGrid = obstacleGrid;

//        CommonUtils.show(obstacleGrid);

        return uniquePathsWithObstaclesCore(0, 0);
    }

    private int uniquePathsWithObstaclesCore(int x, int y) {


        if (x >= X || y >= Y || obstacleGrid[x][y] == 1) {
            return 0;
        }

        if (x == X - 1 && y == Y - 1) {
            return 1;
        }

        return uniquePathsWithObstaclesCore(x + 1, y) + uniquePathsWithObstaclesCore(x, y + 1);
    }
}

class Solution2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int X = obstacleGrid.length, Y = obstacleGrid[0].length;
        int[][] stat = new int[X][Y];
        stat[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;

        // 初始化行
        for (int i = 1; i < Y; i++) {
            stat[0][i] = obstacleGrid[0][i] == 1 ? 0 : stat[0][i - 1];
        }

        // 初始化列
        for (int i = 1; i < X; i++) {
            stat[i][0] = obstacleGrid[i][0] == 1 ? 0 : stat[i - 1][0];
        }

        for (int i = 1; i < X; i++) {
            for (int j = 1; j < Y; j++) {
                stat[i][j] = obstacleGrid[i][j] == 1 ? 0 : stat[i][j - 1] + stat[i - 1][j];
            }
        }

        return stat[X - 1][Y - 1];
    }

}
