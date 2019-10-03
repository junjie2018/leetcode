package T0974;

import Common.CommonUtils;

public class Main {
    public static void main(String[] args) {
        new Solution().subarraysDivByK(CommonUtils.create("[4,5,0,-2,-3,1]"), 5);
//        new Solution().subarraysDivByK(CommonUtils.create("[0,-5]"), 10);
    }
}

class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int len = A.length;

        int[] sums = new int[len + 1];

        for (int i = 0; i < len; i++) {
            sums[i + 1] = sums[i] + A[i];
        }

        int[] counts = new int[K];
        for (int sum : sums) {
            counts[(sum % K + K) % K]++; // 可能出现负数
        }

        int result = 0;
        for (int count : counts) {
            if (count > 1) {
                result += count * (count - 1) / 2;
            }
        }

        return result;
    }
}
