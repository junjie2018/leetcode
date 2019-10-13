package T0092;

import Common.ListNode;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        int pos = 0;
        ListNode cutNode = null;
        ListNode subHead = null, subTail = null;
        ListNode curNode = head, preNode = dummy;
        while (curNode != null) {
            pos++;
            ListNode tmp = curNode.next;
            if (pos == m) {
                cutNode = preNode;
                subHead = curNode;
                subTail = curNode;
            }
            if (pos > m && pos <= n) {
                curNode.next = subHead;
                subHead = curNode;
                if (pos == n) {
                    subTail.next = tmp;
                    cutNode.next = subHead;
                }
            }
            preNode = curNode;
            curNode = tmp;
        }

        return dummy.next;
    }
}