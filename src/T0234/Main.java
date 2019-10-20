package T0234;

import Common.CommonUtils;
import Common.ListNode;

public class Main {
    public static void main(String[] args) {
//        System.out.println(new Solution().isPalindrome(CommonUtils.createListNode("1->2->2->1")));
        System.out.println(new Solution().isPalindrome(CommonUtils.createListNode(CommonUtils.createInt1a(
//                "[1,4,-1,-1,4,1]"
                "[1,1,2,1]"
        ))));
    }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        int len = getLength(head);

        if (len == 1) return true;

        reverseList(dummy, head, len / 2);

        ListNode h1 = dummy.next;
        ListNode h2 = h1;

        int mid = (len + 1) / 2;
        while (mid > 0) {
            h2 = h2.next;
            --mid;
        }

        while (h2 != null) {
            if (h1.val != h2.val) return false;
            h1 = h1.next;
            h2 = h2.next;
        }

        return true;

    }

    private ListNode reverseList(ListNode dummy, ListNode node, int k) {
        if (k == 1) {
            dummy.next = node;
            return node;
        }
        ListNode res = reverseList(dummy, node.next, k - 1);

        node.next = res.next;
        res.next = node;

        return node;
    }

    private int getLength(ListNode head) {
        int len = 0;
        ListNode tmp = head;
        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }
        return len;
    }
}
