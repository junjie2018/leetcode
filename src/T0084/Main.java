package T0084;

import Common.CommonUtils;

import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
//        System.out.println(new Solution3().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(new Solution().largestRectangleArea(new int[]{5, 4, 1, 2}));
    }
}

class Solution {
    public int largestRectangleArea(int[] heights) {

        if (heights.length == 0) {
            return 0;
        }

        Stack<Tuple> stack = new Stack<>();
        stack.push(new Tuple(0, 0));

        int maxValue = Integer.MIN_VALUE;
        for (int i = 1; i < heights.length; i++) {

            int preIdx = i;

            int topIdx = stack.peek().curIdx;
            int topHeight = heights[topIdx];
            int curHeight = heights[i];

            while (curHeight < topHeight) {

                preIdx = stack.pop().preIdx;

                int tmp = topHeight * (i - preIdx);
                maxValue = maxValue > tmp ? maxValue : tmp;

                if (stack.isEmpty()) {
                    topHeight = -1;
                    break;
                }

                topIdx = stack.peek().curIdx;
                topHeight = heights[topIdx];
            }

            if (curHeight > topHeight) {
                stack.push(new Tuple(preIdx, i));
            }
        }

        int leftMost = heights.length;
        while (!stack.isEmpty()) {
            Tuple tuple = stack.pop();
            int topIdx = tuple.curIdx;
            int preIdx = tuple.preIdx;
            int topHeight = heights[topIdx];

            int tmp = topHeight * (leftMost - preIdx);
            maxValue = maxValue > tmp ? maxValue : tmp;
        }

        return maxValue;
    }

    public static class Tuple {
        int preIdx, curIdx;

        Tuple(int preIdx, int curIdx) {
            this.preIdx = preIdx;
            this.curIdx = curIdx;
        }
    }
}

class Solution2 {
    public int largestRectangleArea(int[] heights) {
//        if (heights.length == 0) {
//            return 0;
//        }
        int len = heights.length;

        int maxValue = 0;
        int preMinHeight;
        for (int i = 0; i < len; i++) {

            maxValue = maxValue > heights[i] ? maxValue : heights[i];

            preMinHeight = heights[i];
            for (int j = i + 1; j < len; j++) {
                preMinHeight = Math.min(heights[j], preMinHeight);

                int tmp = preMinHeight * (j - i + 1);
                maxValue = tmp > maxValue ? tmp : maxValue;
            }
        }

        return maxValue;
    }
}

class Solution3 {
    public int largestRectangleArea(int[] heights) {

        if (heights.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int topIdx = stack.peek(), curIdx = i;

            while (topIdx > -1 && heights[curIdx] <= heights[topIdx]) {
                stack.pop();

                max = Math.max(max, heights[topIdx] * (curIdx - stack.peek() - 1));

                topIdx = stack.peek();
            }

            stack.push(curIdx);
        }

        while (stack.peek() != -1) {
            max = Math.max(max, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }

        return max;
    }
}