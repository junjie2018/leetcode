package T0062;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths(7, 3));
    }
}

class Solution {
    public int uniquePaths(int m, int n) {
        return uniquePathsCore(new int[m + 1][n + 1], m, n);
    }

    private int uniquePathsCore(int[][] records, int m, int n) {

        if (m < 1 || n < 1) {
            return 0;
        }

        if (m == 1 && n == 1) {
            return 1;
        }

        if (records[m][n] == 0) {
            int tmp = uniquePathsCore(records, m - 1, n) + uniquePathsCore(records, m, n - 1);
            records[m][n] = tmp;
            return tmp;
        }
        return records[m][n];
    }
}
