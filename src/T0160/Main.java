package T0160;

import Common.ListNode;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode tmp = headA;
        while (tmp != null) {
            set.add(tmp);
            tmp = tmp.next;
        }

        tmp = headB;
        while (tmp != null) {
            if (set.contains(tmp)) {
                return tmp;
            }
            tmp = tmp.next;
        }
        return null;
    }
}

class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA), lenB = getLength(headB);
        if (lenA != lenB) {
            int m = Math.abs(lenA - lenB);
            while (m > 0) {
                if (lenA > lenB) headA = headA.next;
                else headB = headB.next;
                m--;
            }
        }

        while (true) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
    }

    private int getLength(ListNode node) {
        ListNode idx = node;
        int length = 0;
        while (idx != null) {
            length++;
            idx = idx.next;
        }
        return length;
    }
}
