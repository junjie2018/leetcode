package T0124;

import Common.TreeNode;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new Solution().maxPathSum(root));
    }
}

class Solution {
    private static final int MIN_INF = -100000;

    public int maxPathSum(TreeNode root) {
        postOrder(root);
        return maxPath;
    }

    private int maxPath = MIN_INF;

    private int postOrder(TreeNode node) {
        if (node == null) {
            return MIN_INF;
        }

        int pathLeftSum = postOrder(node.left);
        int pathRightSum = postOrder(node.right);

        int tmp1 = Math.max(Math.max(pathLeftSum, pathRightSum) + node.val, node.val);
        int tmp2 = Math.max(tmp1, pathLeftSum + pathRightSum + node.val);
        maxPath = Math.max(maxPath, tmp2);

        return tmp1;
    }
}


