package T0111;

import Common.TreeNode;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        minDepthCore(root, 0);
        return minDepth;
    }

    private int minDepth = Integer.MAX_VALUE;

    private void minDepthCore(TreeNode node, int depth) {

        if (node == null) return;

        depth++;
        if (node.left == null && node.right == null) {
            minDepth = Math.min(minDepth, depth);
            return;
        }

        if (depth < minDepth) {
            minDepthCore(node.left, depth);
            minDepthCore(node.right, depth);
        }
    }
}
