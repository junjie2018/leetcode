package T0289;

public class Main {
    public static void main(String[] args) {
        new Solution().gameOfLife(new int[][]{
                // [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        });
    }
}

class Solution {
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        int[][] boardNext = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int lives = getLives(board, i, j);
                if (lives < 2 || lives > 3) {
                    boardNext[i][j] = 0;
                }
                if (lives == 3) {
                    boardNext[i][j] = 1;
                }
                if (lives == 2) {
                    boardNext[i][j] = board[i][j];
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = boardNext[i][j];
            }
        }
    }

    public int getLives(int[][] board, int i, int j) {
        int lives = 0;
        for (int m = -1; m <= 1; m++) {
            int row = i + m;
            if (row < 0 || row >= board.length) continue;

            for (int n = -1; n <= 1; n++) {
                int col = j + n;
                if (col < 0 || col >= board[0].length || (row == i && col == j)) continue;

                if (board[row][col] == 1) {
                    lives++;
                }
            }
        }
        return lives;
    }
}