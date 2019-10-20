package T0206;

import Common.CommonUtils;
import Common.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        new Solution().reverseList(CommonUtils.createListNode(CommonUtils.createInt1a("[1,2,3,4,5]")));
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {

        if (head == null) return null;

        Deque<ListNode> stack = new ArrayDeque<>();

        ListNode tmp = head;
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.next;
        }

        ListNode dummy = new ListNode(-1);
        tmp = dummy;
        while (stack.size() > 0) {
            tmp.next = stack.pop();
            tmp = tmp.next;
        }
        tmp.next = null;

        return dummy.next;
    }
}
