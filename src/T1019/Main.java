package T1019;

import Common.CommonUtils;
import Common.ListNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        CommonUtils.show(new Solution().nextLargerNodes(
                CommonUtils.createListNode(
                        CommonUtils.createInt1a("[2,1,5]")
                )
        ));
    }
}

@SuppressWarnings("all")
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        if (head == null) return new int[0];

        int len = 0;
        ListNode tmp = head;
        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }

        tmp = head;
        int idx = 0;
        int[] result = new int[len];
        Deque<Tuple> stack = new ArrayDeque<>();
        while (tmp != null) {
            while (stack.size() > 0 && stack.peek().num < tmp.val) {
                Tuple tuple = stack.pop();
                result[tuple.idx] = tmp.val;
            }
            stack.push(new Tuple(tmp.val, idx));
            tmp = tmp.next;
            idx++;
        }

        return result;
    }

    private static class Tuple {
        int num;
        int idx;

        public Tuple(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }
}
