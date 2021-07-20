import Common.ListNode;

public class T0002 {

    public static void main(String[] args) {

    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int value, c = 0; // 值与进位

            ListNode result = null, idx = null;

            while (l1 != null && l2 != null) {

                value = (l1.val + l2.val + c) % 10;
                c = (l1.val + l2.val + c) / 10;

                if (idx == null) {
                    result = new ListNode(value);
                    idx = result;
                } else {
                    idx.next = new ListNode(value);
                    idx = idx.next;
                }

                l1 = l1.next;
                l2 = l2.next;
            }

            while (l1 != null) {
                value = (l1.val + c) % 10;
                c = (l1.val + c) / 10;

                if (idx == null) {
                    result = new ListNode(value);
                    idx = result;
                } else {
                    idx.next = new ListNode(value);
                    idx = idx.next;
                }

                l1 = l1.next;
            }

            while (l2 != null) {
                value = (l2.val + c) % 10;
                c = (l2.val + c) / 10;

                if (idx == null) {
                    result = new ListNode(value);
                    idx = result;
                } else {
                    idx.next = new ListNode(value);
                    idx = idx.next;
                }

                l2 = l2.next;
            }

            if (c != 0) {
                idx.next = new ListNode(c);
            }

            return result;
        }
    }
}
