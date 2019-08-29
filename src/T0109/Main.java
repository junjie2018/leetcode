package T0109;

import Common.ListNode;
import Common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {

    private int idx = 0;
    private Deque<Integer> stack = new ArrayDeque<>();

    public TreeNode sortedListToBST(ListNode head) {
        int idx = 0;
        int[] array = new int[2048];
        while (head != null) {
            array[idx++] = head.val;
            head = head.next;
        }

        return sortedListToBSTCore(array, 0, idx - 1);
    }

    private TreeNode sortedListToBSTCore(int[] nums, int start, int end) {

        if (start > end) return null;

        int mid = (start + end) / 2;

        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedListToBSTCore(nums, start, mid - 1);
        node.right = sortedListToBSTCore(nums, mid + 1, end);

        return node;
    }

}