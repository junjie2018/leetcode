package T1052;

import Common.CommonUtils;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        System.out.println(
                new Solution().maxSatisfied(
//                        CommonUtils.createInt1a("[1,0,1,2,1,1,7,5]"),
//                        CommonUtils.createInt1a("[0,1,0,1,0,1,0,1]"),
//                        3
                        /*
                            [4,2,5,7]
                            [0,1,1,1]
                            2
                         */
//                        CommonUtils.createInt1a("[4,2,5,7]"),
//                        CommonUtils.createInt1a("[0,1,1,1]"),
//                        2
                        /*
                            [10,1,7]
                            [0,0,0]
                            2
                         */
                        CommonUtils.createInt1a("[10,1,7]"),
                        CommonUtils.createInt1a("[0,0,0]"),
                        2
                ));
    }
}

@SuppressWarnings("all")
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        Deque<Integer> queue = new ArrayDeque<>();
        int tmpMax = 0;


        for (int i = 0; i < X; i++) {
            if (grumpy[i] == 1) {
                queue.addFirst(i);
                tmpMax += customers[i];
            }
        }

        int max = tmpMax;
        for (int i = 1; i <= grumpy.length - X; i++) {
            int start = i, end = i + X - 1; // 左闭 右闭

            if (grumpy[end] == 1) {
                queue.addFirst(end);
                tmpMax += customers[end];
            }

            if (queue.size() > 0 && queue.getLast() < start) {
                int idx = queue.removeLast();
                tmpMax -= customers[idx];
            }

            if (tmpMax > max) max = tmpMax;
        }

        int sum = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) sum += customers[i];
        }
        sum += max;

        return sum;
    }
}