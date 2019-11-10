package T0661;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    private int[][] M;
    private int rows, cols;

    public int[][] imageSmoother(int[][] M) {
        this.M = M;
        this.rows = M.length;
        this.cols = M[0].length;

        int[][] res = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Tuple tuple = new Tuple(M[i][j], 1);
                dispose(i + 1, j, tuple);
                dispose(i - 1, j, tuple);
                dispose(i, j + 1, tuple);
                dispose(i, j - 1, tuple);
                dispose(i + 1, j + 1, tuple);
                dispose(i + 1, j - 1, tuple);
                dispose(i - 1, j + 1, tuple);
                dispose(i - 1, j - 1, tuple);
                res[i][j] = tuple.sum / tuple.count;
            }
        }
        return res;
    }

    private void dispose(int i, int j, Tuple tuple) {
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            return;
        }
        tuple.sum += M[i][j];
        tuple.count++;
    }

    private static class Tuple {
        int sum;
        int count;

        public Tuple(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }
}

//    int count = 1;
//    int sum = M[i][j];
//                if (i - 1 >= 0) sum += M[i - 1][j];
//                        if (i + 1 <= r) sum += M[i + 1][j];
//                        if (j - 1 >= 0) sum += M[i][j - 1];
//                        if (j + 1 <= c) sum += M[i][j + 1];
//
//                        if (i - 1 >= 0 && j - 1 >= 0) sum += M[i - 1][j - 1];
//                        if (i - 1 >= 0 && j + 1 <= c) sum += M[i - 1][j + 1];
//                        if (i + 1 <= r && j - 1 >= 0) sum += M[i + 1][j - 1];
//                        if (i + 1 <= r && j + 1 >= c) sum += M[i + 1][j + 1];
