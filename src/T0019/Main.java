package T0019;

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode faster = head;
        while (n-- > 1) {
            faster = faster.next;
        }

        ListNode slower = null;
        while (faster.next != null) {
            faster = faster.next;
            slower = slower == null ? head : slower.next;
        }

        if(slower==null){
            return head.next;
        }else {
            slower.next=slower.next.next;
            return head;
        }
    }
}
