package T0130;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                //[["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        new Solution().solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.printf("%c  ", board[i][j]);
            }
            System.out.println();
        }
    }
}

class Solution {

    private int rows, cols;
    private char[][] board;
    private boolean[][] flags;
    private boolean[][] changeFlags;

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        this.rows = board.length;
        this.cols = board[0].length;
        this.board = board;
        this.flags = new boolean[rows][cols];
        this.changeFlags = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O' && !flags[i][j]) {
                    if (!traverseO(i, j)) {
                        changeO2X(i, j);
                    }
                }
            }
        }
    }

    /**
     * 返回true表示，遍历的O中有处于边界位置上的
     */
    private boolean traverseO(int i, int j) {
        if (board[i][j] != 'O') {
            return false;
        }

        if (i <= 0 || i >= rows - 1 || j <= 0 || j >= cols - 1) {
            return true;
        }

        if (flags[i][j]) {
            return false;
        }

        flags[i][j] = true;

        boolean result = false;
        if (traverseO(i - 1, j)
                | traverseO(i + 1, j)
                | traverseO(i, j - 1)
                | traverseO(i, j + 1)) {
            result = true;
        }

        return result;
    }

    private void changeO2X(int i, int j) {
        if (board[i][j] != 'O') {
            return;
        }

        if (changeFlags[i][j]) {
            return;
        }

        changeFlags[i][j] = true;

        boolean result = false;
        changeO2X(i - 1, j);
        changeO2X(i + 1, j);
        changeO2X(i, j - 1);
        changeO2X(i, j + 1);

        board[i][j] = 'X';
    }
}
