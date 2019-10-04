package T0025;

import Common.ListNode;
import Common.CommonUtils;

public class Main {
    public static void main(String[] args) {
        ListNode head = CommonUtils.createListNode(new int[]{1, 2, 3, 4, 5});
        CommonUtils.show(new Solution2().reverseKGroup(head, 3));
    }
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode[] lists = new ListNode[k];

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode curNode = dummy;
        while (true) {
            ListNode curNode2 = curNode;
            for (int i = 0; i < k; i++) {
                if (curNode2.next != null) {
                    lists[i] = curNode2.next;
                    curNode2 = curNode2.next;
                } else {
                    return dummy.next;
                }
            }

            ListNode next = lists[lists.length - 1].next;
            for (int i = lists.length - 1; i > 0; i--) {
                lists[i].next = lists[i - 1];
            }
            lists[0].next = next;
            curNode.next = lists[lists.length - 1];

            curNode = lists[0];
        }
    }
}


class Solution2 {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;


        ListNode curNode = dummy;
        ListNode index = curNode;
        while (true) {
            // 检测剩余数据是够足够形成一组
            for (int i = 0; i < k; i++) {
                if (index.next != null) {
                    index = index.next;
                } else {
                    return dummy.next;
                }
            }

            ListNode pivot = curNode.next; //将pivot后面的结点插入到curNode之后
            for (int i = 1; i < k; i++) {
                ListNode temp = pivot.next;
                pivot.next = temp.next;
                temp.next = curNode.next;
                curNode.next = temp;
            }

            curNode = pivot;
            index = curNode;
        }

    }
}
