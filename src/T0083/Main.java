package T0083;

import Common.ListNode;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        if(head==null){
            return null;
        }

        ListNode pivot = head;
        ListNode index = head.next;
        while (index != null) {
            if (index.val != pivot.val) {
                pivot.next = index;
                pivot = index;
            }
            index = index.next;
        }
        pivot.next = index;

        return head;
    }
}
