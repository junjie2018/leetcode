package T0082;

import Common.CommonUtils;
import Common.ListNode;

public class Main {
    public static void main(String[] args) {
//        new Solution().deleteDuplicates(CommonUtils.create(new int[]{1, 2, 3, 3, 4, 4, 5}));
        new Solution().deleteDuplicates(CommonUtils.create(new int[]{1, 1}));
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        boolean existBefore = false;
        ListNode pivot = dummy;
        ListNode preNode = dummy, curNode = head;

        while (curNode != null) {
            if (curNode.val != preNode.val) {
                if (existBefore) {
                    pivot.next = curNode;
                    existBefore = false;
                } else {
                    pivot = preNode;
                }
            } else {
                existBefore = true;
            }
            preNode = curNode;
            curNode = curNode.next;
        }
        pivot.next = existBefore ? null : pivot.next;
        return dummy.next;
    }
}