package T1004;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().longestOnes(new int[]{
                1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0
        }, 2));
    }
}

class Solution {
    public int longestOnes(int[] A, int K) {
        int low = 0, high = 0;

        int k = K;
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) {
                high++;
            } else {
                // 如果这个时候还有将0变成1的次数，则将0变成1
                if (k > 0) {
                    high++;
                    k--;
                }
                // 如果这个时候没有将0变成1的次数，则low++，知道退还一个将0变成1的次数
                else {
                    max = Math.max(max, high - low);
                    while (A[low] == 1) {
                        low++;
                    }
                    low++;
                    high++;
                }
            }
        }
        return Math.max(max, high - low);
    }
}
