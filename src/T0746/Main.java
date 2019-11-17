package T0746;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int pre = cost[1], ppre = cost[0];

        for (int i = 2; i < cost.length; i++) {
            // 到底i的成本为:
            int tmp = Math.min(ppre, pre) + cost[i];
            ppre = pre;
            pre = tmp;
        }

        return Math.min(ppre, pre);
    }
}