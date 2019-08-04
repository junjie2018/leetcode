package T1043;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maxSumAfterPartitioning(new int[]{
                1, 15, 7, 9, 2, 5, 10
        }, 3));
    }
}

class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {

        int[] maxs = new int[A.length];
        maxs[0] = A[0];

        for (int i = 1; i < A.length; i++) {
            maxs[i] = A[i] + maxs[i - 1];
            int curMaxA = A[i];
            for (int j = i - 1; j >= 0 && j > i - K; j--) {
                curMaxA = Math.max(curMaxA, A[j]);
                if (j - 1 >= 0) {
                    maxs[i] = Math.max(maxs[i], curMaxA * (i - j + 1) + maxs[j - 1]);
                } else {
                    maxs[i] = Math.max(maxs[i], curMaxA * (i - j + 1));
                    break;
                }
            }
        }
        return maxs[A.length - 1];
    }
}