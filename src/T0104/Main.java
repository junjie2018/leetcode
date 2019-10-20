package T0104;

import Common.TreeNode;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {

    private int depth;

    public int maxDepth(TreeNode root) {
        this.depth = 0;

        maxDepthCore(root, 1);

        return this.depth;
    }

    private void maxDepthCore(TreeNode node, int cur) {
        if (node == null) return;

        if (cur > depth) depth = cur;

        maxDepthCore(node.left, cur + 1);
        maxDepthCore(node.right, cur + 1);
    }
}