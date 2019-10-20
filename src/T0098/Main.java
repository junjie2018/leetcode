package T0098;

import Common.CommonUtils;
import Common.TreeNode;

public class Main {
    public static void main(String[] args) {
//        new Solution().isValidBST(CommonUtils.createTreeNode("[2,1,3]"));
        System.out.println(new Solution().isValidBST(CommonUtils.createTreeNode("[-2147483648,null,2147483647]")));
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        return isValidBSTCore(root) != null;
    }

    private Tuple isValidBSTCore(TreeNode node) {
        if (node == null) {
            return new Tuple(Long.MAX_VALUE, Long.MIN_VALUE);
        }

        if (node.left == null && node.right == null) {
            return new Tuple(node.val, node.val);
        } else {
            if (node.left != null && node.left.val >= node.val) return null;
            if (node.right != null && node.right.val <= node.val) return null;

            Tuple leftTuple, rightTuple;
            if ((leftTuple = isValidBSTCore(node.left)) == null) return null;
            if ((rightTuple = isValidBSTCore(node.right)) == null) return null;

            if (leftTuple.max >= node.val) return null;
            if (rightTuple.min <= node.val) return null;

            return new Tuple(leftTuple.min, rightTuple.max);
        }
    }

    private static class Tuple {
        Long min;
        Long max;

        public Tuple(long min, long max) {
            this.min = min;
            this.max = max;
        }
    }
}

