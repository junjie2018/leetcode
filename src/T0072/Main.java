package T0072;

public class Main {
    public static void main(String[] args) {
//        System.out.println(new Solution().minDistance("horse", "ros"));
        System.out.println(new Solution().minDistance("intention", "execution"));
    }
}

class Solution {
    public int minDistance(String word1, String word2) {
        /*
                 word1
            word2     r o s
                   h
                   o
                   r
                   s
                   e
         */
        int ROWS = word1.length(), COLS = word2.length();

        int[][] stat = new int[ROWS + 1][COLS + 1];
        stat[0][0] = 0;

        for (int i = 1; i < ROWS + 1; i++) {
            stat[i][0] = i;
        }

        for (int i = 1; i < COLS + 1; i++) {
            stat[0][i] = i;
        }

        for (int i = 0; i < ROWS; i++) {
            char rowChar = word1.charAt(i);
            for (int j = 0; j < COLS; j++) {
                char colChar = word2.charAt(j);

                int m = i + 1, n = j + 1;

                // 将colChar改变成rowChar
                int steps1 = colChar == rowChar ? stat[m - 1][n - 1] : stat[m - 1][n - 1] + 1;
                // 直接删除colChar
                int steps2 = stat[m - 1][n] + 1;
                // 直接插入rowChar
                int steps3 = stat[m][n - 1] + 1;

                stat[m][n] = steps1 < steps2 ? (steps1 < steps3 ? steps1 : steps3) : (steps2 < steps3 ? steps2 : steps3);
            }
        }

        return stat[ROWS][COLS];
    }
}
