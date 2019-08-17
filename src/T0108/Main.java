package T0108;

import Common.TreeNode;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return sortedArrayToBSTCore(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBSTCore(int[] nums, int start, int end) {

        if (start > end) return null;

        int mid = (start + end) / 2;

        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBSTCore(nums, start, mid - 1);
        node.right = sortedArrayToBSTCore(nums, mid + 1, end);

        return node;
    }
}