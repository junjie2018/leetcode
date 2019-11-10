package T0687;

import Common.TreeNode;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int longestUnivaluePath(TreeNode root) {
        if (null == root) return 0;
        longestUnivaluePathCore(root);
        return max;
    }

    private int max = 0;

    private int longestUnivaluePathCore(TreeNode node) {
        if (null == node.left && null == node.right) return 0;

        if (null != node.left && null != node.right) {
            if (node.val != node.left.val && node.val != node.right.val) {
                longestUnivaluePathCore(node.left);
                longestUnivaluePathCore(node.right);
                return 0;
            }

            if (node.val == node.left.val && node.val == node.right.val) {
                int l = longestUnivaluePathCore(node.left);
                int r = longestUnivaluePathCore(node.right);

                if (l + r + 2 > max) max = l + r + 2;

                return Math.max(l + 1, r + 1);
            }

            if (node.val == node.left.val) {
                longestUnivaluePathCore(node.right);
                int l = longestUnivaluePathCore(node.left);
                if (l + 1 > max) max = l + 1;
                return l + 1;
            }

            if (node.val == node.right.val) {
                longestUnivaluePathCore(node.left);
                int r = longestUnivaluePathCore(node.right);
                if (r + 1 > max) max = r + 1;
                return r + 1;
            }
        }

        if (null != node.left) {
            if (node.val == node.left.val) {
                int l = longestUnivaluePathCore(node.left);
                if (l + 1 > max) max = l + 1;
                return l + 1;
            }
            longestUnivaluePathCore(node.left);
            return 0;
        } else {
            if (node.val == node.right.val) {
                int r = longestUnivaluePathCore(node.right);
                if (r + 1 > max) max = r + 1;
                return r + 1;
            }
            longestUnivaluePathCore(node.right);
            return 0;
        }
    }
}

