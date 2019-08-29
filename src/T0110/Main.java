package T0110;

import Common.TreeNode;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    private boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        height(root);
        return flag;
    }

    private int height(TreeNode root) {
        if (root == null)
            return 0;

        int left = height(root.left);
        int right = height(root.right);

        if (Math.abs(left - right) > 1) flag = false;

        return 1 + Math.max(left, right);
    }
}