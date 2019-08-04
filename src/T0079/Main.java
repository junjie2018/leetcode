package T0079;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'},
        }, "ABCESEEEFS"));
//        int[][] a = new int[3][3];
//        int[][] b = Arrays.copyOf(a, a.length);
//        a[1][1] = 10;
//        System.out.println(b[1][1]);
    }
}

class Solution {

    private char[][] board;
    private String word;
    private int rows, cols;

    public boolean exist(char[][] board, String word) {

        this.board = board;
        this.word = word;

        this.rows = board.length;
        this.cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (existCore(new int[rows][cols], i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean existCore(int[][] flags, int i, int j, int n) {

        if (i < 0 || j < 0 || i >= rows || j >= cols) {
            return false;
        }

        if (board[i][j] != word.charAt(n)) {
            return false;
        }

        if (flags[i][j] == 1) {
            return false;
        }

        if (n == word.length() - 1) {
            return true;
        }


        int[][] tmp = new int[rows][cols];
        for (int k = 0; k < rows; k++) {
            tmp[k] = flags[k].clone();
        }
        tmp[i][j] = 1;

        return existCore(tmp, i + 1, j, n + 1)
                || existCore(tmp, i - 1, j, n + 1)
                || existCore(tmp, i, j + 1, n + 1)
                || existCore(tmp, i, j - 1, n + 1);
    }
}

class Solution2 {

    private char[][] board;
    private String word;
    private int rows, cols;

    public boolean exist(char[][] board, String word) {

        this.board = board;
        this.word = word;

        this.rows = board.length;
        this.cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (existCore(i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean existCore(int i, int j, int n) {

        if (i < 0 || j < 0 || i >= rows || j >= cols) {
            return false;
        }

        if (board[i][j] != word.charAt(n)) {
            return false;
        }

        if (n == word.length() - 1) {
            return true;
        }

        board[i][j] ^= 256;
        boolean result = existCore(i + 1, j, n + 1)
                || existCore(i - 1, j, n + 1)
                || existCore(i, j + 1, n + 1)
                || existCore(i, j - 1, n + 1);
        board[i][j] ^= 256;

        return result;
    }
}