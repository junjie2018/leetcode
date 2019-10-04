package T0061;

import Common.ListNode;
import Common.CommonUtils;

public class Main {
    public static void main(String[] args) {
        CommonUtils.show(new Solution().rotateRight(CommonUtils.createListNode(new int[]{1}), 1));
    }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null) {
            return null;
        }

        if (k == 0) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        int len = 0;
        ListNode tail = dummy;
        while (tail.next != null) {
            len++;
            tail = tail.next;
        }

        k = k % len;
        if (k == 0) {
            return head;
        }
        ListNode kNode = dummy;
        for (int i = 0; i < len - k; i++) {
            kNode = kNode.next;
        }

        ListNode tmp = kNode.next;
        tail.next = dummy.next;
        dummy.next = tmp;
        kNode.next = null;

        return dummy.next;
    }
}
