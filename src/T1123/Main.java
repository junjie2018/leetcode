package T1123;

import Common.CommonUtils;
import Common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        new Solution().lcaDeepestLeaves(root);
    }
}

class Solution {
    private TreeNode result = null;
    private int max = -1;

    public TreeNode lcaDeepestLeaves(TreeNode root) {


        lcaDeepestLeavesCore(root, 0);

        return result;
    }

    private int lcaDeepestLeavesCore(TreeNode node, int depth) {
        if (node == null) return --depth;

        int leftDepth = lcaDeepestLeavesCore(node.left, depth + 1);
        int rightDepth = lcaDeepestLeavesCore(node.right, depth + 1);

        if (leftDepth == rightDepth) {
            if (leftDepth >= max) {
                result = node;
                max = leftDepth;
            }
        }

        return Math.max(leftDepth, rightDepth);
    }
}
