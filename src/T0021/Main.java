package T0021;

public class Main {
    public static void main(String[] args) {

    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);


        ListNode curListNode = head;
        ListNode left = l1, right = l2;
        while (left != null && right != null) {

            ListNode temp;
            if (left.val < right.val) {
                temp = left;
                left = left.next;
            } else {
                temp = right;
                right = right.next;
            }

            curListNode.next = temp;
            curListNode = curListNode.next;
        }

        curListNode.next = left != null ? left : right;

        return head.next;
    }
}

class Solution2 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);

        ListNode temp = head;
        ListNode left = l1, right = l2;
        while (left.next != null && right.next != null) {
            temp.next = new ListNode(Math.min(left.val, right.val));
            temp = temp.next;
            if (left.val < right.val) left = left.next;
            else right = right.next;
        }

        while (left.next != null) {
            temp.next = new ListNode(left.val);
        }

        while (right.next != null) {
            temp.next = new ListNode(right.val);
        }

        return head.next;
    }
}