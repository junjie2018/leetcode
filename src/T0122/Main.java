package T0122;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0) return 0;

        int sum = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < prices.length; i++) {
            if (stack.size() > 0 && prices[i] < stack.peek()) {
                sum += stack.getFirst() - stack.getLast();
                stack.clear();
            }
            stack.push(prices[i]);
        }
        if (stack.size() > 0) sum += stack.getFirst() - stack.getLast();
        return sum;
    }
}

/*
    修改该算法，更好的服务T0123，发现没有用，貌似要用T0121
 */
class Solution2 {
    public int maxProfit(int[] prices) {
        int returnNums = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                returnNums += prices[i] - prices[i - 1];
            }
        }

        return returnNums;
    }
}