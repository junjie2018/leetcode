package T0112;

import Common.TreeNode;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {

    private int sum;

    public boolean hasPathSum(TreeNode root, int sum) {
        this.sum = sum;
        return hasPathSumCore(root, 0);
    }

    private boolean hasPathSumCore(TreeNode node, int curSum) {
        if (node == null) return false;

        curSum += node.val;
        if (node.left == null && node.right == null) {
            if (curSum == sum) return true;
        }

        if (hasPathSumCore(node.left, curSum)) return true;
        if (hasPathSumCore(node.right, curSum)) return true;

        return false;
    }
}
