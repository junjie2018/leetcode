package T0918;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maxSubarraySumCircular(new int[]{
//                1, -2, 3, -2
//                5, -3, 5
                -10, -7, 9, -7, 6, 9, -9, -4, -8, -5
        }));
    }
}

class Solution {
    public int maxSubarraySumCircular(int[] A) {


        int sum = 0, maxValue = Integer.MIN_VALUE;
        int maxPartialSum = 0, minPartialSum = 0;
        int partialSumForCondition1 = 0, partialSumForCondition2 = 0;
        for (int a : A) {
            // 情况一：没有跨边界，求连续序列和最大值
            partialSumForCondition1 += a;
            if (partialSumForCondition1 < 0) partialSumForCondition1 = 0;
            if (partialSumForCondition1 > maxPartialSum) maxPartialSum = partialSumForCondition1;

            // 情况二：跨边界了
            partialSumForCondition2 += a;
            if (partialSumForCondition2 > 0) partialSumForCondition2 = 0;
            if (partialSumForCondition2 < minPartialSum) minPartialSum = partialSumForCondition2;

            // 统计和与最大值
            sum += a;
            if (a > maxValue) maxValue = a;
        }

        if (maxPartialSum == 0) {
            return maxValue;
        }

        return Math.max(sum - minPartialSum, maxPartialSum);
    }
}
