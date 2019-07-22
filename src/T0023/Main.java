package T0023;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int[][] arrays = new int[][]{{1, 4, 5}, {1, 3, 4}, {2, 6}};
        ListNode[] lists = new ListNode[3];
        for (int i = 0; i < arrays.length; i++) {
            int[] array = arrays[i];
            ListNode head = new ListNode(-1);
            ListNode curNode = head;
            for (int j = 0; j < array.length; j++) {
                curNode.next = new ListNode(array[j]);
                curNode = curNode.next;
            }
            lists[i] = head.next;
        }

        show(new Solution3().mergeKLists(lists));
    }

    private static void show(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(-1);

        PriorityQueue<ListNode> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.val, e2.val));
        for (ListNode listNode : lists) {
            if (listNode != null) {
                pq.add(listNode);
            }
        }

        ListNode curNode = head;
        while (pq.size() > 0) {
            ListNode temp = pq.poll();
            curNode.next = temp;
            curNode = curNode.next;
            if (temp.next != null) {
                pq.add(temp.next);
            }
        }

        return head.next;
    }
}

class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(-1);

        ListNode curListNode = head;
        int index = getMin(lists);
        while (index != -1) {
            ListNode listNode = lists[index];
            lists[index] = lists[index].next;

            curListNode.next = listNode;
            curListNode = curListNode.next;

            index = getMin(lists);
        }

        return head.next;
    }

    private int getMin(ListNode[] lists) {
        int index = -1;
        boolean flag = false;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                if (!flag) {
                    flag = true;
                    index = i;
                    continue;
                }
                if (lists[i].val < lists[index].val) {
                    index = i;
                }
            }
        }
        return index;
    }
}

class Solution3 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0){
            return null;
        }

        return split(lists, 0, lists.length - 1);
    }

    public ListNode split(ListNode[] lists, int left, int right) {
        if (left >= right) {
            return lists[left];
        }

        int mid = (left + right) / 2;

        return mergeTwoLists(split(lists, left, mid), split(lists, mid + 1, right));
    }

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
