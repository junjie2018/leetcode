package T0979;

import Common.TreeNode;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(0);
//        TreeNode right = new TreeNode(0);

        root.left = left;
//        root.right = right;

        new Solution().distributeCoins(root);
    }
}

class Solution {
    private int step = 0;

    public int distributeCoins(TreeNode root) {
        distributeCoinsCore(root);
        return step;
    }

    private Tuple distributeCoinsCore(TreeNode node) {
        Tuple result = new Tuple(1, node.val);

        if (node.left != null) {
            Tuple left = distributeCoinsCore(node.left);
            step += Math.abs(left.values - left.nodes);

            result.nodes += left.nodes;
            result.values += left.values;
        }

        if (node.right != null) {
            Tuple right = distributeCoinsCore(node.right);
            step += Math.abs(right.values - right.nodes);

            result.nodes += right.nodes;
            result.values += right.values;
        }

        return result;
    }

    static class Tuple {

        public Tuple(int nodes, int values) {
            this.nodes = nodes;
            this.values = values;
        }

        int nodes;
        int values;
    }
}