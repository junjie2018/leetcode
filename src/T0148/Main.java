package T0148;

import Common.CommonUtils;
import Common.ListNode;

public class Main {
    public static void main(String[] args) {
        new Solution().sortList(CommonUtils.createL("4->2->1->3"));
    }
}

@SuppressWarnings("all")
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) return null;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }

        sortListCore(dummy, len);

        return dummy.next;
    }

    // 返回的是尾部元素
    private void sortListCore(ListNode dummy, int len) {
        if (1 == len) return;

        int leftLen = len / 2, rightLen = len - leftLen;

        // 处理左边
        ListNode leftDummy = dummy;
        sortListCore(leftDummy, leftLen);

        // 处理右边
        ListNode rightDummy = dummy;
        int tmp = leftLen;
        ListNode tmpNode = dummy;
        while (tmp > 0) {
            rightDummy = rightDummy.next;
            tmp--;
        }
        sortListCore(rightDummy, rightLen);

        // 合并结果
        ListNode head = dummy;
        ListNode leftHead = leftDummy.next;
        ListNode rightHead = rightDummy.next;
        while (leftLen > 0 && rightLen > 0) {
            if (leftHead.val < rightHead.val) {
                head.next = leftHead;
                head = head.next;
                leftHead = leftHead.next;
                leftLen--;
            } else {
                head.next = rightHead;
                head = head.next;
                rightHead = rightHead.next;
                rightLen--;
            }
        }
        while (leftLen > 0) {
            head.next = leftHead;
            head = head.next;
            leftHead = leftHead.next;
            leftLen--;
        }
        while (rightLen > 0) {
            head.next = rightHead;
            head = head.next;
            rightHead = rightHead.next;
            rightLen--;
        }

        head.next = rightHead;
        return;
    }
}
