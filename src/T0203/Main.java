package T0203;

import Common.ListNode;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode idx = dummy;
        while (idx.next != null) {
            if (idx.next.val == val) {
                idx.next = idx.next.next;
                continue;
            }
            idx = idx.next;
        }
        return dummy.next;
    }
}
