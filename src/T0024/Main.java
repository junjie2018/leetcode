package T0024;

import Common.ListNode;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next=head;

        ListNode curNode = dummy;
        while( curNode.next!=null && curNode.next.next!=null){
            ListNode temp = curNode.next;
            curNode.next=curNode.next.next;
            temp.next=curNode.next.next;
            curNode.next.next=temp;

            curNode=curNode.next.next;
        }

        return dummy.next;
    }
}


