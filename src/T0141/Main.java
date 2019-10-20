package T0141;

import Common.ListNode;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean hasCycle(ListNode head) {
        int idx = 50000;
        ListNode tmp = head;
        while (tmp != null) {
            if (tmp.val > 50000) {
                return true;
            }
            tmp.val = idx++;
            tmp = tmp.next;
        }
        return false;
    }
}
