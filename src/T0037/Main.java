package T0037;

import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String[][] board = new String[][]{
                {"5", "3", ".", ".", "7", ".", ".", ".", "."},
                {"6", ".", ".", "1", "9", "5", ".", ".", "."},
                {".", "9", "8", ".", ".", ".", ".", "6", "."},
                {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
                {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
                {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
                {".", "6", ".", ".", ".", ".", "2", "8", "."},
                {".", ".", ".", "4", "1", "9", ".", ".", "5"},
                {".", ".", ".", ".", "8", ".", ".", "7", "9"}
        };
//        new Solution().solveSudoku(board);
    }
}

class Solution {
    public void solveSudoku(char[][] board) {
        Sudoku sudoku = new Sudoku(board);
        solveSudokuCore(sudoku);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    board[i][j] = (char) ('0' + sudoku.get(i, j));
                }
            }
        }

    }

    private boolean solveSudokuCore(Sudoku sudoku) {

        if (sudoku.blanks.size() <= 0) {
            return true;
        }

        Sudoku.Blank blank = sudoku.blanks.pop();
        for (int target = 1; target <= 9; target++) {
            if (sudoku.isVolidate(blank.i, blank.j, target)) {
                sudoku.set(blank.i, blank.j, target);
                if (solveSudokuCore(sudoku)) {
                    return true;
                }
                sudoku.remove(blank.i, blank.j);
            }
        }
        sudoku.blanks.push(blank);
        return false;
    }


    static class Sudoku {
        private int[][] values = new int[9][9];
        private boolean[][] flags = new boolean[9][9]; // 记录值是够可以被抹除
        Stack<Blank> blanks = new Stack<>();

        static class Blank {
            int i;
            int j;

            public Blank(int i, int j) {
                this.i = i;
                this.j = j;
            }
        }

        public Sudoku(char[][] board) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        flags[i][j] = false;
                        values[i][j] = board[i][j] - '0';
                    } else {
                        blanks.push(new Blank(i, j));
                    }
                }
            }
        }

        private boolean isVolidate(int i, int j, int target) {
            // 验证行
            for (int r = 0; r < 9; r++) {
                if (values[r][j] == target) {
                    return false;
                }
            }

            // 验证列
            for (int c = 0; c < 9; c++) {
                if (values[i][c] == target) {
                    return false;
                }
            }

            // 验证所在区域
            int row = (i / 3) * 3;
            int col = (j / 3) * 3;
            for (int r = row; r < row + 3; r++) {
                for (int c = col; c < col + 3; c++) {
                    if (values[r][c] == target) {
                        return false;
                    }
                }
            }

            return true;
        }

        public void set(int i, int j, int target) {
            values[i][j] = target;
        }

        public void remove(int i, int j) {
            values[i][j] = 0;
        }

        public void show() {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.printf("%2d", values[i][j]);
                }
                System.out.println();
            }
        }

        public int get(int i, int j) {
            return values[i][j];
        }
    }
}

class Solution2 {

    private boolean[][] mRow = new boolean[9][9];

    private boolean[][] mCol = new boolean[9][9];

    private boolean[][] mSquare = new boolean[9][9];

    public void solveSudoku(char[][] board) {

        for (int aRow = 0; aRow < 9; aRow++) {
            for (int aCol = 0; aCol < 9; aCol++) {
                if (board[aRow][aCol] != '.') {
                    int aVal = board[aRow][aCol] - '1';
                    mRow[aRow][aVal] = true;
                    mCol[aCol][aVal] = true;
                    mSquare[(aRow / 3) * 3 + aCol / 3][aVal] = true;
                }
            }
        }

        trySolve(board, 0, 0);
    }

    private boolean trySolve(char[][] board, int pRow, int pCol) {

        if (pRow == -1) {
            return true;
        }

        int aNextRow = pRow + 1;
        int aNextCol = pCol;

        if (aNextRow == 9) {
            aNextRow = 0;
            aNextCol += 1;
        }

        if (aNextCol == 9) {
            aNextRow = -1;
            aNextCol = -1;
        }

        if (board[pRow][pCol] != '.') {
            return trySolve(board, aNextRow, aNextCol);
        }

        final int aBox = (pRow / 3) * 3 + pCol / 3;

        for (int aTry = 0; aTry < 9; aTry++) {

            if (mRow[pRow][aTry] || mCol[pCol][aTry] || mSquare[aBox][aTry]) {
                continue;
            }

            board[pRow][pCol] = (char) (aTry + '1');

            mRow[pRow][aTry] = true;
            mCol[pCol][aTry] = true;
            mSquare[aBox][aTry] = true;

            if (trySolve(board, aNextRow, aNextCol)) {
                return true;
            }

            mRow[pRow][aTry] = false;
            mCol[pCol][aTry] = false;
            mSquare[aBox][aTry] = false;

        }

        board[pRow][pCol] = '.';
        return false;
    }

    private static void print(char[][] board) {
        for (int aRow = 0; aRow < 9; aRow++) {
            for (int aCol = 0; aCol < 9; aCol++) {
                System.out.print(board[aRow][aCol] + " ");
            }
            System.out.println();
        }
    }
}

class Solution3 {

    private char[][] result;

    private boolean[][] rowFlags = new boolean[9][9];
    private boolean[][] colFlags = new boolean[9][9];
    private boolean[][] areaFlags = new boolean[9][9];
    private ArrayList<Tuple> blanks = new ArrayList<>(81);

    public void solveSudoku(char[][] board) {

        this.result = board;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    rowFlags[i][num] = true;
                    colFlags[j][num] = true;
                    areaFlags[(i / 3) * 3 + j / 3][num] = true;
                } else {
                    blanks.add(new Tuple(i, j));
                }
            }
        }

        sloveSudokuCore();


    }

    private boolean volidate(int i, int j, int target) {
        return !rowFlags[i][target] && !colFlags[j][target] && !areaFlags[(i / 3) * 3 + j / 3][target];
    }

    private void setFlagsAndResult(int i, int j, int target) {
        rowFlags[i][target] = true;
        colFlags[j][target] = true;
        areaFlags[(i / 3) * 3 + j / 3][target] = true;

        result[i][j] = (char) (target + '1');
    }

    private void removeFlagsAndResult(int i, int j, int target) {
        rowFlags[i][target] = false;
        colFlags[j][target] = false;
        areaFlags[(i / 3) * 3 + j / 3][target] = false;

        result[i][j] = '.';
    }

    private boolean sloveSudokuCore() {

        if (blanks.size() <= 0) {
            return true;
        }

        Tuple tuple = blanks.remove(blanks.size() - 1);

        for (int target = 0; target < 9; target++) {
            if (volidate(tuple.i, tuple.j, target)) {
                setFlagsAndResult(tuple.i, tuple.j, target);
                if (sloveSudokuCore()) return true;
                removeFlagsAndResult(tuple.i, tuple.j, target);
            }
        }

        blanks.add(tuple);
        return false;
    }

    static class Tuple {
        int i, j;

        public Tuple(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}