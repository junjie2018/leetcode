package T0543;

import Common.CommonUtils;
import Common.TreeNode;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().diameterOfBinaryTree(
                CommonUtils.createTreeNode("[1,2,3,4,5]")
        ));
    }
}

class Solution {
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        diameterOfBinaryTreeCore(root);
        return max;
    }

    public int diameterOfBinaryTreeCore(TreeNode node) {
        if (null == node) return -1;

        int left = diameterOfBinaryTreeCore(node.left);
        int right = diameterOfBinaryTreeCore(node.right);

        max = Math.max(max, left + right + 2);
        max = Math.max(max, Math.max(left, right + 1));

        return Math.max(left, right) + 1;
    }
}
