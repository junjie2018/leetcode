package T0446;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//        System.out.println(new Solution().numberOfArithmeticSlices(new int[]{2, 2, 3, 4, 5, 6}));
        System.out.println(new Solution().numberOfArithmeticSlices(new int[]{0, 2000000000, -294967296}));
    }
}

class Solution {
    public int numberOfArithmeticSlices(int[] A) {

        int len = A.length;

        int[][] dp = new int[len][len];

        int sum = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                long target = (long) 2 * A[j] - (long) A[i];
                int targetIdx = getTargetIdx(A, j, target);
                while (targetIdx != -1) {
                    dp[i][j]++;
                    dp[i][j] += dp[j][targetIdx];
                    targetIdx = getTargetIdx(A, targetIdx, target);
                }
                sum += dp[i][j];
            }
        }
        return sum;
    }

    private int getTargetIdx(int[] A, int start, long target) {
        for (int i = start - 1; i >= 0; i--) {
            if (A[i] == target) {
                return i;
            }
        }
        return -1;
    }
}