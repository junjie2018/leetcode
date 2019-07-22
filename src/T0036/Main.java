package T0036;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {

    public boolean isValidSudoku(char[][] board) {

        boolean[][] rowFlags = new boolean[9][9];
        boolean[][] colFlags = new boolean[9][9];
        boolean[][] areaFlags = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int aNum = board[i][j] - '1';
                    if (rowFlags[i][aNum] || colFlags[j][aNum] || areaFlags[(i / 3) * 3 + j / 3][aNum]) {
                        return false;
                    }

                    rowFlags[i][aNum] = true;
                    colFlags[j][aNum] = true;
                    areaFlags[(i / 3) * 3 + j / 3][aNum] = true;
                }
            }
        }
        return true;
    }
}

