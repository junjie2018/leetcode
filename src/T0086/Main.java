package T0086;

import Common.CommonUtils;
import Common.ListNode;

public class Main {
    public static void main(String[] args) {
        new Solution().partition(CommonUtils.createListNode(CommonUtils.createInt1a("[1,4,3,2,5,2]")), 3);
    }
}

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(-1);
        ListNode bigHead = new ListNode(-1);

        ListNode smallIdx = smallHead;
        ListNode bigIdx = bigHead;

        ListNode node = head;
        while (node != null) {
            if (node.val < x) {
                smallIdx.next = node;
                smallIdx = smallIdx.next;
            } else {
                bigIdx.next = node;
                bigIdx = bigIdx.next;
            }
            node = node.next;
        }

        bigIdx.next = null;
        smallIdx.next = bigHead.next;
        return smallHead.next;
    }
}
