package T1139;

import Common.CommonUtils;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().largest1BorderedSquare(new int[][]{
                // [[1,1,1],[1,0,1],[1,1,1]]
//                {1, 1, 1},
//                {1, 0, 1},
//                {1, 1, 1}
                // [[1,1,1],[1,1,0],[1,1,1],[0,1,1],[1,1,1]]
                {1, 1, 1},
                {1, 0, 0},
                {1, 1, 1},
                {0, 1, 1},
                {1, 1, 1}
        }));
    }
}

class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;

        boolean flag = false;
        int[][] edgeRowLength = new int[rows][cols], edgeColLength = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            if (grid[i][cols - 1] == 1) {
                flag = true;
                edgeRowLength[i][cols - 1] = 1;
            }
            for (int j = cols - 2; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    flag = true;
                    edgeRowLength[i][j] = edgeRowLength[i][j + 1] + 1;
                }
            }
        }
        for (int j = 0; j < cols; j++) {
            if (grid[rows - 1][j] == 1) {
                flag = true;
                edgeColLength[rows - 1][j] = 1;
            }
            for (int i = rows - 2; i >= 0; i--) {
                if (grid[i][j] == 1) {
                    flag = true;
                    edgeColLength[i][j] = edgeColLength[i + 1][j] + 1;
                }
            }
        }
        if (!flag) {
            return 0;
        }
//        CommonUtils.show(edgeRowLength);
//        System.out.println();
//        CommonUtils.show(edgeColLength);
//        System.out.println();


        int curMaxLength = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    int topRightLength = Math.min(edgeRowLength[i][j], edgeColLength[i][j]);
                    if (topRightLength <= curMaxLength) {
                        continue;
                    }

                    for (int len = topRightLength; len >= 2 && len > curMaxLength; len--) {
                        int bottomLeftLength = Math.min(edgeRowLength[i + len - 1][j], edgeColLength[i][j + len - 1]);
                        if (bottomLeftLength >= len) {
                            curMaxLength = len;
                        }
                    }
                }
            }
        }

        return curMaxLength * curMaxLength;
    }
}
