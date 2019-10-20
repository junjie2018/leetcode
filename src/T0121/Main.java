package T0121;

import Common.CommonUtils;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution2().maxProfit(CommonUtils.createInt1a("[7,1,5,3,6,4]")));
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < prices.length; i++) {
            while (stack.size() > 0 && stack.peek() > prices[i]) {
                max = Math.max(max, stack.getFirst() - stack.getLast());
                stack.pop();
            }
            stack.push(prices[i]);
        }
        if (stack.size() > 0) max = Math.max(max, stack.getFirst() - stack.getLast());
        return max;
    }
}

class Solution2 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int len = prices.length;

        int[] l2r = new int[len], r2l = new int[len];
        l2r[0] = prices[0];
        r2l[len - 1] = prices[len - 1];
        for (int i = 1; i < len; i++) {
            l2r[i] = Math.min(l2r[i - 1], prices[i]);
        }
        for (int i = len - 2; i >= 0; i--) {
            r2l[i] = Math.max(r2l[i + 1], prices[i]);
        }

        int max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, r2l[i] - l2r[i]);
        }

        return max;
    }
}
