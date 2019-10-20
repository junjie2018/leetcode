package T0099;

import Common.CommonUtils;
import Common.TreeNode;

public class Main {
    public static void main(String[] args) {
        new Solution().recoverTree(CommonUtils.createTreeNode("[2,3,1]"));
    }
}

/*
    这是一个耍赖皮的解法。。。
 */
class Solution {
    public void recoverTree(TreeNode root) {
        Tuple tuple = recoverTreeCore(root);
        while (tuple.isResult) {
            int tmp = tuple.min.val;
            tuple.min.val = tuple.max.val;
            tuple.max.val = tmp;
            tuple = recoverTreeCore(root);
        }
        System.out.println();
    }

    private Tuple recoverTreeCore(TreeNode node) {
        if (node.left == null && node.right == null) {
            return new Tuple(node, node);
        } else {
            Tuple result = new Tuple(node, node);
            if (node.left != null) {
                if (node.left.val >= node.val) return new Tuple(true, node, node.left);
                Tuple leftTuple = recoverTreeCore(node.left);
                if (leftTuple.isResult) return leftTuple;
                if (leftTuple.max.val >= node.val) return new Tuple(true, node, leftTuple.max);
                result.min = leftTuple.min;
            }
            if (node.right != null) {
                if (node.right.val <= node.val) return new Tuple(true, node, node.right);
                Tuple rightTuple = recoverTreeCore(node.right);
                if (rightTuple.isResult) return rightTuple;
                if (rightTuple.min.val <= node.val) return new Tuple(true, node, rightTuple.min);
                result.max = rightTuple.max;
            }
            return result;
        }
    }

    private static class Tuple {
        boolean isResult;
        TreeNode min;
        TreeNode max;

        public Tuple(boolean isResult, TreeNode min, TreeNode max) {
            this.isResult = isResult;
            this.min = min;
            this.max = max;
        }

        public Tuple(TreeNode min, TreeNode max) {
            this.min = min;
            this.max = max;
        }
    }
}