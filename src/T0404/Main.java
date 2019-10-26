package T0404;

import Common.TreeNode;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {

    private int sum;

    public int sumOfLeftLeaves(TreeNode root) {
        if (null == root) return 0;
        this.sum = 0;

        sumOfLeftLeavesCore(root, false);

        return sum;
    }

    private void sumOfLeftLeavesCore(TreeNode node, boolean isLeftChild) {
        if (node.left == null && node.right == null && isLeftChild) {
            sum += node.val;
            return;
        }

        if (node.left != null) {
            sumOfLeftLeavesCore(node.left, true);
        }

        if (node.right != null) {
            sumOfLeftLeavesCore(node.right, false);
        }
    }
}
